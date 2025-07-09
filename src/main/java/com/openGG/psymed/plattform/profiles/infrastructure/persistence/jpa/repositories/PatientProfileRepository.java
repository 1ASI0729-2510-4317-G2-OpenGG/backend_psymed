package com.openGG.psymed.plattform.profiles.infrastructure.persistence.jpa.repositories;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.PatientProfile;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.AccountId;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {
    boolean existsByEmail(Email emailAddress);
    Optional<PatientProfile> findByAccountId(AccountId accountId);
    Long findClinicalHistoryIdById(Long patientId);
    List<PatientProfile> findByProfessionalId(Long professionalId);
}
