package com.openGG.psymed.plattform.Medical_Management.medic_sections.interfaces.rest.resources;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public record SectionResource(

        @Schema(description = "Unique identifier of the medical section", example = "98765")
        Long id,

        @Schema(description = "ID of the patient to whom this medical section belongs", example = "12345")
        Long patientId,

        @Schema(description = "Type of the medical section (e.g., DIAGNOSIS, THERAPY, NOTES)", example = "THERAPY")
        String type,

        @Schema(description = "Detailed content or notes of the medical section", example = "Weekly therapy session focusing on cognitive behavioral techniques.")
        String content,

        @Schema(description = "Date when the medical section was created", example = "2025-06-12")
        LocalDate createdAt

) {}