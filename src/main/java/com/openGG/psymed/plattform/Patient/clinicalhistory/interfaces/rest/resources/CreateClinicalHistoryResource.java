package com.openGG.psymed.plattform.Patient.clinicalhistory.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateClinicalHistoryResource(
        String background,
        String consultationReason,
        LocalDate consultationDate
) {
}
