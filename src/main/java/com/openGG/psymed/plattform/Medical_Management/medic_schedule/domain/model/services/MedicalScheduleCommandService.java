package com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.services;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;

import java.util.UUID;

/**
 * Domain service interface for handling commands related to medical schedules.
 * Defines operations for creating and deleting medical schedule entries.
 */
public interface MedicalScheduleCommandService {

    /**
     * Creates a new medical schedule based on the provided command data.
     *
     * @param command the command containing the medical schedule data
     * @return the UUID of the created schedule
     */
    UUID createMedicalSchedule(CreateMedicalScheduleCommand command);

    /**
     * Deletes a medical schedule if the given medic is the owner.
     *
     * @param scheduleId the ID of the schedule to delete
     * @param medicId the ID of the medic attempting to delete the schedule
     */
    void deleteMedicalSchedule(UUID scheduleId, Long medicId);
}
