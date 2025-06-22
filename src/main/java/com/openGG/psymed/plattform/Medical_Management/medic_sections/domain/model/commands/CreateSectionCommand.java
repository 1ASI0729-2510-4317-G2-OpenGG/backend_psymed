package com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands;

import java.time.LocalDate;

/**
 * Command object used to request the creation of a new {@code Section}.
 * Encapsulates the information required to create a section for a patient,
 * such as the type of section, content, and creation date.
 *
 * @param patientId the unique identifier of the patient to whom the section belongs
 * @param type the type of section (e.g., diagnosis, therapy, notes)
 * @param content the content or description of the section
 * @param createdAt the date the section was created
 */

public record CreateSectionCommand(
        Long patientId,
        String type,
        String content,
        LocalDate createdAt
) { }