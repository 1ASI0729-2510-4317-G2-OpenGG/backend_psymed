package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.commands.CreateMedicalScheduleCommand;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.CreateMedicalScheduleResource;

public class CreateMedicalScheduleCommandFromResourceAssembler {
    public static CreateMedicalScheduleCommand toCommand(CreateMedicalScheduleResource resource) {
        return new CreateMedicalScheduleCommand(
                resource.background(),
                resource.consultationReason(),
                resource.consultationDate()
        );
    }
}