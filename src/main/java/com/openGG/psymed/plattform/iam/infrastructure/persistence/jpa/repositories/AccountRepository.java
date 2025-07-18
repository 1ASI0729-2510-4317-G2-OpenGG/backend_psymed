package com.openGG.psymed.plattform.iam.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.iam.domain.model.aggregate.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByUserName(String username);
    Optional<Account> findByUserName(String username);
}
