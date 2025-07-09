package com.openGG.psymed.plattform.Medics.medic_sections.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medics.medic_sections.domain.model.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA repository interface for managing {@link Section} entities.
 * Provides basic CRUD operations and custom queries for medical sections.
 */

public interface SectionRepository extends JpaRepository<Section, Long> {

    /**
     * Retrieves all sections associated with a specific patient.
     *
     * @param patientId the ID of the patient
     * @return a list of {@link Section} entities related to the given patient
     */

    List<Section> findByPatientId(Long patientId);
}