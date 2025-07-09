package com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.resources;

import java.time.LocalDate;

public record ClinicalHistoryResource(
        Long clinicalHistoryId,
        String background,
        String consultationReason,
        LocalDate consultationDate
) {
}
