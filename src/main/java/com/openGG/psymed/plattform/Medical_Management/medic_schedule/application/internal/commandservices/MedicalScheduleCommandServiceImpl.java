package com.openGG.psymed.plattform.Medical_Management.medic_schedule.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories.MedicalScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Application service implementation that handles commands related to {@link MedicalSchedule}.
 * <p>
 * This service is responsible for creating and deleting medical schedules,
 * ensuring business rules such as medic ownership are respected.
 * </p>
 */

@Service
public class MedicalScheduleCommandServiceImpl implements MedicalScheduleCommandService {

    private final MedicalScheduleRepository repository;

    public MedicalScheduleCommandServiceImpl(MedicalScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID createMedicalSchedule(CreateMedicalScheduleCommand command) {
        UUID id = UUID.randomUUID();
        MedicalSchedule schedule = new MedicalSchedule(
                id,
                command.medicId(),
                command.patientId(),
                command.background(),
                command.consultationReason(),
                command.consultationDate()
        );
        repository.save(schedule);
        return id;
    }

    @Override
    public void deleteMedicalSchedule(UUID scheduleId, Long medicId) {
        var schedule = repository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));

        if (!schedule.getMedicId().equals(medicId)) {
            throw new SecurityException("You are not allowed to delete this schedule");
        }

        repository.delete(schedule);
    }
}