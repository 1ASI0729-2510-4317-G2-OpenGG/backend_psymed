package com.openGG.psymed.plattform.Medics.tasks.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medics.tasks.domain.model.aggregates.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
    Optional<Tasks> findByTitle(String title);
    boolean existsByTitle(String title);

    //boolean existsById(Long id);
}