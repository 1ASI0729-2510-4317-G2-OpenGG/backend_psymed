package com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalScheduleRepository extends JpaRepository<MedicalSchedule, UUID> {}