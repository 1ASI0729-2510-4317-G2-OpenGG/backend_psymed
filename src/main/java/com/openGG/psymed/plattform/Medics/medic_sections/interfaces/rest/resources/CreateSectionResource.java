package com.openGG.psymed.plattform.Medics.medic_sections.interfaces.rest.resources;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * Resource object used to receive data from the client for creating a new {@code Section}.
 * Typically used as the request body in POST endpoints related to medical sections.
 *
 * @param patientId  the ID of the patient associated with the section
 * @param type       the type/category of the section (e.g., DIAGNOSIS, THERAPY, NOTES)
 * @param content    the content or description of the section
 * @param createdAt  the date the section was created
 */

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