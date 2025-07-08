package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands;

import java.time.LocalDate;

/**
 * Command object used to request the creation of a new {@code MedicalSchedule}.
 * <p>
 * This command encapsulates all the necessary data to create a schedule,
 * including the patient and medic identifiers, the patient's medical background,
 * the reason for consultation, and the scheduled consultation date.
 * </p>
 *
 * @param patientId          the unique identifier of the patient
 * @param medicId            the unique identifier of the medic creating the schedule
 * @param background         the patient's medical background or history
 * @param consultationReason the reason for the consultation
 * @param consultationDate   the date the consultation is scheduled for
 */

public record CreateMedicalScheduleCommand(
        Long patientId,
        Long medicId,
        String background,
        String consultationReason,
        LocalDate consultationDate
) {}