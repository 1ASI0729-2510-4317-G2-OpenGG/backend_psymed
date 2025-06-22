package com.openGG.psymed.plattform.Medical_Management.medic_schedule.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories.MedicalScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Implementation of the command service for managing medical schedules.
 * Responsible for handling the creation logic of {@link MedicalSchedule} instances.
 */

@Service
public class MedicalScheduleCommandServiceImpl implements MedicalScheduleCommandService {

    private final MedicalScheduleRepository repository;

    /**
     * Constructs a new {@code MedicalScheduleCommandServiceImpl} with the given repository.
     *
     * @param repository the repository used to persist medical schedule entities
     */

    public MedicalScheduleCommandServiceImpl(MedicalScheduleRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new medical schedule using the provided command.
     *
     * @param command the command containing the required information to create a new medical schedule,
     *                including background, consultation reason, and consultation date
     */

    @Override
    public void createMedicalSchedule(CreateMedicalScheduleCommand command) {
        MedicalSchedule history = new MedicalSchedule(
                UUID.randomUUID(),
                command.background(),
                command.consultationReason(),
                command.consultationDate()
        );
        repository.save(history);
    }
}