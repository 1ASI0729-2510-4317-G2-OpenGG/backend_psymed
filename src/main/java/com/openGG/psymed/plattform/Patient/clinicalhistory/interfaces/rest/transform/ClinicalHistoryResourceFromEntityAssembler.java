package com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.transform;

import com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.aggregates.ClinicalHistory;
import com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.resources.ClinicalHistoryResource;

public class ClinicalHistoryResourceFromEntityAssembler {
    public static ClinicalHistoryResource toResourceFromEntity(ClinicalHistory entity) {
        return new ClinicalHistoryResource(
                entity.getId(),
                entity.getBackground(),
                entity.getConsultationReason(),
                entity.getConsultationDate()
        );
    }

}
