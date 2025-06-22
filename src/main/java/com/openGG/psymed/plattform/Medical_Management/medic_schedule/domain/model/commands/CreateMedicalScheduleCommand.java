package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands;

import java.time.LocalDate;

public record CreateMedicalScheduleCommand(
        String background,
        String consultationReason,
        LocalDate consultationDate
) {}