package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;

import java.util.List;

/**
 * Query service interface for retrieving {@link MedicalSchedule} entities.
 * <p>
 * Provides read-only access to medical schedules associated with a specific patient.
 * This interface is typically used within the application layer to enforce
 * a clear separation between queries and commands following the CQRS pattern.
 * </p>
 */
public interface MedicalScheduleQueryService {

    /**
     * Retrieves all medical schedules assigned to the given patient.
     *
     * @param patientId the unique identifier of the patient
     * @return a list of {@link MedicalSchedule} objects associated with the patient
     */
    List<MedicalSchedule> getSchedulesByPatientId(Long patientId);
}