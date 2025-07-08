package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;

/**
 * Assembler class responsible for transforming a {@link CreateMedicalScheduleResource}
 * into a {@link CreateMedicalScheduleCommand} to be processed by the application layer.
 */

public class CreateMedicalScheduleCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateMedicalScheduleResource} and medic ID into a {@link CreateMedicalScheduleCommand}.
     *
     * @param resource the resource received from the client representing the schedule creation request
     * @param medicId  the ID of the medic creating the schedule (resolved from authentication or context)
     * @return a command object representing the request to create a new medical schedule
     */

    public static CreateMedicalScheduleCommand toCommand(CreateMedicalScheduleResource resource, Long medicId) {
        return new CreateMedicalScheduleCommand(
                medicId,
                resource.patientId(),
                resource.background(),
                resource.consultationReason(),
                resource.consultationDate()
        );
    }
}