package com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.commands;

import java.time.LocalDate;

public record CreateSectionCommand(
        Long patientId,
        String type,
        String content,
        LocalDate createdAt
) { }