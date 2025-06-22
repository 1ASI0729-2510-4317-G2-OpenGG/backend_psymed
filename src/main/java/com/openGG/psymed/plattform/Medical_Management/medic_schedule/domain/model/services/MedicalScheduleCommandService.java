package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;

/**
 * Domain service interface for handling commands related to medical schedules.
 * Defines operations for creating new medical schedule entries.
 */

public interface MedicalScheduleCommandService {

    /**
     * Creates a new medical schedule based on the provided command data.
     *
     * @param command the command containing the medical schedule data, such as background,
     *                consultation reason, and consultation date
     */

    void createMedicalSchedule(CreateMedicalScheduleCommand command);
}