package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record CreateSectionResource(

        @Schema(
                description = "ID of the patient associated with the medical section",
                example = "12345"
        )
        Long patientId,

        @Schema(
                description = "Type of the medical section (e.g., DIAGNOSIS, THERAPY, NOTES)",
                example = "DIAGNOSIS"
        )
        String type,

        @Schema(
                description = "Detailed content or notes of the medical section",
                example = "The patient has been experiencing symptoms of anxiety for the past two weeks."
        )
        String content,

        @Schema(
                description = "Date when the medical section was created",
                example = "2025-06-12"
        )
        LocalDate createdAt

) {}