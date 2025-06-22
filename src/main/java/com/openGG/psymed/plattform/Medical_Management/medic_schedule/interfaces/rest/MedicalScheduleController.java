package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform.CreateMedicalScheduleCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schedules")
@Tag(name="medical-schedules", description = "Manage a patient's appointments")
public class MedicalScheduleController {

    private final MedicalScheduleCommandService commandService;

    public MedicalScheduleController(MedicalScheduleCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    @Operation(summary = "Create medical schedule")
    public ResponseEntity<Void> create(@RequestBody CreateMedicalScheduleResource resource) {
        var command = CreateMedicalScheduleCommandFromResourceAssembler.toCommand(resource);
        commandService.createMedicalSchedule(command);
        return ResponseEntity.ok().build();
    }
}