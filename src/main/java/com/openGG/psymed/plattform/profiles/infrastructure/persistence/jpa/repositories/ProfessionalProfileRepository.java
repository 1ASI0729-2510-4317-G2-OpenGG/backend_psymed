package com.openGG.psymed.plattform.profiles.infrastructure.persistence.jpa.repositories;


import com.openGG.psymed.plattform.profiles.domain.model.aggregates.ProfessionalProfile;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.AccountId;
import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalProfileRepository extends JpaRepository<ProfessionalProfile, Long> {
    boolean existsByEmail(Email email);

    Optional<ProfessionalProfile> findByAccountId(AccountId accountId);
}
