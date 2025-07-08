package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources;

import java.time.LocalDate;

/**
 * Resource representation of a medical schedule, used for REST communication.
 * <p>
 * Encapsulates the data related to a medical appointment, including patient and medic identifiers,
 * background information, reason for consultation, and the scheduled date.
 * </p>
 *
 * @param id                 the unique identifier of the schedule (as a String UUID)
 * @param patientId          the ID of the patient associated with the schedule
 * @param background         the background or medical history of the patient
 * @param consultationReason the reason for the medical consultation
 * @param consultationDate   the date on which the consultation is scheduled
 * @param medicId            the ID of the medic assigned to the consultation
 */

public record MedicalScheduleResource(
        String id,
        Long patientId,
        String background,
        String consultationReason,
        LocalDate consultationDate,
        Long medicId
) {}