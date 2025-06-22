package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * Resource used to receive data from the client when creating a new {@code MedicalSchedule}.
 * This class is typically used as the body of POST requests in the medical schedule API.
 *
 * @param background         the patient's medical history
 * @param consultationReason the reason for the consultation
 * @param consultationDate   the date the consultation is scheduled for
 */

public record CreateMedicalScheduleResource(
        @Schema(description = "Patient history", example = "Patient with history of anxiety")
        String background,
        @Schema(description = "Reason for consultation", example = "Consultation for insomnia and stress")
        String consultationReason,
        @Schema(description = "Consultation date", example = "2025-06-12")
        LocalDate consultationDate
) {}