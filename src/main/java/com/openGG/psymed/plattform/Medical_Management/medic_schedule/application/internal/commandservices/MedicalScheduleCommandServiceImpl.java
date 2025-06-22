package com.openGG.psymed.plattform.Medical_Management.medic_schedule.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services.MedicalScheduleCommandService;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.persistence.jpa.repositories.MedicalScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MedicalScheduleCommandServiceImpl implements MedicalScheduleCommandService {

    private final MedicalScheduleRepository repository;

    public MedicalScheduleCommandServiceImpl(MedicalScheduleRepository repository) {
        this.repository = repository;
    }

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