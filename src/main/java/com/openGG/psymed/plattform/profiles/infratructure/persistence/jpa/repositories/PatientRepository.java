package com.openGG.psymed.plattform.profiles.infratructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.profiles.domain.model.aggregates.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByName(String name);

    Optional<Patient> findByLastName(String lastName);


    boolean existsByEmail(String email);
}
