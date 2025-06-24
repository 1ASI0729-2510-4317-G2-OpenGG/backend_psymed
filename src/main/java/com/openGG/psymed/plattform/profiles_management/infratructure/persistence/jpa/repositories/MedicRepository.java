package com.openGG.psymed.plattform.profiles_management.infratructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicRepository extends JpaRepository<Medic, Long> {

    Optional<Medic> findByName(String name);

    Optional<Medic> findByEmail(String email);

    Optional<Medic> findByLastName(String lastName);
    boolean existsByEmail(String email);
}
