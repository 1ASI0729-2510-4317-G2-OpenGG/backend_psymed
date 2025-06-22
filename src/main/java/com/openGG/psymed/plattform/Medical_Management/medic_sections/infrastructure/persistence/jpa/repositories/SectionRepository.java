package com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.domain.model.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByPatientId(Long patientId);
}