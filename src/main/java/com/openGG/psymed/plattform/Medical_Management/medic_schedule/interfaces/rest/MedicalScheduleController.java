package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleQueryService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.acl.external.profiles.ProfileContextFacade;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.MedicalScheduleResource;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform.CreateMedicalScheduleCommandFromResourceAssembler;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform.MedicalScheduleResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for handling operations related to medical schedules.
 */

@RestController
@RequestMapping("/api/v1/schedules")
@Tag(name = "medical-schedules", description = "Manage a patient's appointments")
public class MedicalScheduleController {

    private final MedicalScheduleCommandService commandService;
    private final MedicalScheduleQueryService queryService;
    private final ProfileContextFacade profileContextFacade;

    /**
     * Constructs a new controller with the required dependencies.
     *
     * @param commandService        service to handle command operations
     * @param queryService          service to handle query operations
     * @param profileContextFacade  ACL to resolve medicId using email
     */

    public MedicalScheduleController(MedicalScheduleCommandService commandService,
                                     MedicalScheduleQueryService queryService,
                                     ProfileContextFacade profileContextFacade) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.profileContextFacade = profileContextFacade;
    }

    /**
     * Endpoint to create a new medical schedule.
     *
     * @param email    the medic's email passed in the request header
     * @param resource the medical schedule creation request body
     * @return the generated UUID of the new schedule
     */

    @PostMapping
    @Operation(summary = "Create medical schedule")
    public ResponseEntity<UUID> create(@RequestHeader("X-User-Email") String email,
                                       @RequestBody CreateMedicalScheduleResource resource) {
        Long medicId = profileContextFacade.getMedicIdFromEmail(email);
        var command = CreateMedicalScheduleCommandFromResourceAssembler.toCommand(resource, medicId);
        UUID scheduleId = commandService.createMedicalSchedule(command);
        return ResponseEntity.ok(scheduleId);
    }

    /**
     * Endpoint to delete a medical schedule by its ID.
     * Only the medic who owns the schedule can perform this operation.
     *
     * @param scheduleId the ID of the schedule to delete
     * @param userEmail  the medic's email passed in the request header
     * @return HTTP 204 No Content if successfully deleted
     */

    @DeleteMapping("/{scheduleId}")
    @Operation(summary = "Delete medical schedule by ID (only by owner)")
    public ResponseEntity<Void> delete(@PathVariable UUID scheduleId,
                                       @RequestHeader("X-User-Email") String userEmail) {
        Long medicId = profileContextFacade.getMedicIdFromEmail(userEmail);
        commandService.deleteMedicalSchedule(scheduleId, medicId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint to retrieve all medical schedules associated with a patient.
     *
     * @param patientId the ID of the patient
     * @return a list of {@link MedicalScheduleResource} objects
     */

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get medical schedules by patient ID")
    public ResponseEntity<List<MedicalScheduleResource>> getByPatientId(@PathVariable Long patientId) {
        var schedules = queryService.getSchedulesByPatientId(patientId);
        var resources = schedules.stream()
                .map(MedicalScheduleResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}