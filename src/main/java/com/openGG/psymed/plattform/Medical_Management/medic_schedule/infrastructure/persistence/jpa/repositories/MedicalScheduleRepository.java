package com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


/**
 * JPA repository interface for managing {@link MedicalSchedule} entities.
 * Provides basic CRUD operations and query capabilities by extending {@link JpaRepository}.
 */

public interface MedicalScheduleRepository extends JpaRepository<MedicalSchedule, UUID> {}