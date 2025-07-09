package com.openGG.psymed.plattform.Patient_Management.clinicalhistory.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateClinicalHistoryResource(
        String background,
        String consultationReason,
        LocalDate consultationDate
) {
}
