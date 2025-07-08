package com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * JPA repository interface for accessing {@link MedicalSchedule} entities from the database.
 * <p>
 * Provides methods to perform CRUD operations and custom queries related to medical schedules.
 * </p>
 */
public interface MedicalScheduleRepository extends JpaRepository<MedicalSchedule, UUID> {

    /**
     * Retrieves all medical schedules associated with a specific patient ID.
     *
     * @param patientId the unique identifier of the patient
     * @return a list of {@link MedicalSchedule} entities for the given patient
     */
    List<MedicalSchedule> findByPatientId(Long patientId);
}