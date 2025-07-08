package com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.transform;

import com.openGG.psymed.plattform.Medical_Management.medic_schedule.domain.model.aggregates.MedicalSchedule;
import com.openGG.psymed.plattform.Medical_Management.medic_schedule.interfaces.rest.resources.MedicalScheduleResource;

/**
 * Assembler class responsible for converting a {@link MedicalSchedule} entity
 * into a {@link MedicalScheduleResource} used by the REST interface layer.
 */
public class MedicalScheduleResourceFromEntityAssembler {

    /**
     * Transforms a domain entity {@link MedicalSchedule} into a REST resource {@link MedicalScheduleResource}.
     *
     * @param entity the domain model representing a stored or loaded medical schedule
     * @return a resource object used for REST responses
     */
    public static MedicalScheduleResource toResourceFromEntity(MedicalSchedule entity) {
        return new MedicalScheduleResource(
                entity.getId().toString(),
                entity.getPatientId(),
                entity.getBackground(),
                entity.getConsultationReason(),
                entity.getConsultationDate(),
                entity.getMedicId()
        );
    }
}