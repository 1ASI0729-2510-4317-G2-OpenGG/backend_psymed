package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record CreateMedicalScheduleResource(
        @Schema(description = "Patient history", example = "Patient with history of anxiety")
        String background,
        @Schema(description = "Reason for consultation", example = "Consultation for insomnia and stress")
        String consultationReason,
        @Schema(description = "Consultation date", example = "2025-06-12")
        LocalDate consultationDate
) {}