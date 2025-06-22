package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;

public interface MedicalScheduleCommandService {
    void createMedicalSchedule(CreateMedicalScheduleCommand command);
}