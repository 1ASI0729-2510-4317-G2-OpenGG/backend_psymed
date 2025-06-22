package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands;

import java.time.LocalDate;

/**
 * Command object used to request the creation of a new {@code MedicalSchedule}.
 * It encapsulates the patient's background, the reason for consultation,
 * and the consultation date.
 *
 * @param background         the patient's medical background or history
 * @param consultationReason the reason for the consultation
 * @param consultationDate   the date the consultation is scheduled for
 */

public record CreateMedicalScheduleCommand(
        String background,
        String consultationReason,
        LocalDate consultationDate
) {}