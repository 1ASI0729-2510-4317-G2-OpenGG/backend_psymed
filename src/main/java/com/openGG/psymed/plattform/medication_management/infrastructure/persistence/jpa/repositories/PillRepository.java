package com.openGG.psymed.plattform.medication_management.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.medication_management.domain.model.aggregates.Pills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PillRepository extends JpaRepository<Pills, Long> {
    Optional<Pills> findByName(String name);
    boolean existsByName(String name);

    List<Pills> findByPatientId(Long patientId);


    //boolean existsById(Long id);
}