package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;

/**
 * Assembler class responsible for transforming a {@link CreateMedicalScheduleResource}
 * into a {@link CreateMedicalScheduleCommand}, which can be used in the application layer.
 */

public class CreateMedicalScheduleCommandFromResourceAssembler {

    /**
     * Converts a {@link CreateMedicalScheduleResource} into a {@link CreateMedicalScheduleCommand}.
     *
     * @param resource the REST resource received from the client
     * @return a command object used to trigger the creation of a medical schedule
     */

    public static CreateMedicalScheduleCommand toCommand(CreateMedicalScheduleResource resource) {
        return new CreateMedicalScheduleCommand(
                resource.background(),
                resource.consultationReason(),
                resource.consultationDate()
        );
    }
}