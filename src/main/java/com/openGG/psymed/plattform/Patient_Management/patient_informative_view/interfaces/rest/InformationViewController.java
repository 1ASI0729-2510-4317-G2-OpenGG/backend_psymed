package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.application.internal.queryservices.*;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries.*;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that provides read-only access to a patient's medical schedules,
 * medication, and assigned tasks.
 *
 * <p>This controller is part of the "patient informative view" context and is designed
 * for patients or other read-only consumers to retrieve data about their medical activity.</p>
 */

@RestController
@RequestMapping("/api/v1/patient")
@Tag(name = "patient-informative", description = "View a patient's appointments, pills, and tasks")
public class InformationViewController {

    private final ViewMedicalSchedulesQueryService scheduleQueryService;
    private final ViewPatientPillsQueryService pillQueryService;
    private final ViewPatientTasksQueryService taskQueryService;

    public InformationViewController(
            ViewMedicalSchedulesQueryService scheduleQueryService,
            ViewPatientPillsQueryService pillQueryService,
            ViewPatientTasksQueryService taskQueryService) {
        this.scheduleQueryService = scheduleQueryService;
        this.pillQueryService = pillQueryService;
        this.taskQueryService = taskQueryService;
    }

    @GetMapping("/schedules/{patientId}")
    public ResponseEntity<List<ScheduleViewResource>> getSchedulesByPatientId(@PathVariable Long patientId) {
        var result = scheduleQueryService.handle(new GetSchedulesByPatientIdQuery(patientId));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/pills/{patientId}")
    public ResponseEntity<List<PillViewResource>> getPillsByPatientId(@PathVariable Long patientId) {
        var result = pillQueryService.handle(new GetPillsByPatientIdQuery(patientId));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tasks/{patientId}")
    public ResponseEntity<List<TaskViewResource>> getTasksByPatientId(@PathVariable Long patientId) {
        var result = taskQueryService.handle(new GetTasksByPatientIdQuery(patientId));
        return ResponseEntity.ok(result);
    }
}