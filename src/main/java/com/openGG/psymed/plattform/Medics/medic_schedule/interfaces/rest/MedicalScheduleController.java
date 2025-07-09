package com.openGG.psymed.plattform.Medics.medic_schedule.interfaces.rest;

import com.openGG.psymed.plattform.Medics.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medics.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;
import com.openGG.psymed.plattform.Medics.medic_schedule.interfaces.rest.transform.CreateMedicalScheduleCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing medical schedule operations.
 * Provides endpoints for creating patient medical schedules.
 */

@RestController
@RequestMapping("/api/v1/schedules")
@Tag(name="medical-schedules", description = "Manage a patient's appointments")
public class MedicalScheduleController {

    private final MedicalScheduleCommandService commandService;

    /**
     * Constructor for injecting the {@link MedicalScheduleCommandService}.
     *
     * @param commandService the service responsible for handling schedule creation logic
     */

    public MedicalScheduleController(MedicalScheduleCommandService commandService) {
        this.commandService = commandService;
    }

    /**
     * Endpoint to create a new medical schedule.
     *
     * @param resource the resource object containing the schedule details sent in the request body
     * @return HTTP 200 OK if creation was successful
     */

    @PostMapping
    @Operation(summary = "Create medical schedule")
    public ResponseEntity<Void> create(@RequestBody CreateMedicalScheduleResource resource) {
        var command = CreateMedicalScheduleCommandFromResourceAssembler.toCommand(resource);
        commandService.createMedicalSchedule(command);
        return ResponseEntity.ok().build();
    }
}