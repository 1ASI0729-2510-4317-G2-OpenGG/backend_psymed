package com.openGG.psymed.plattform.Patient.clinicalhistory.domain.model.commands;

import java.time.LocalDate;

public record CreateClinicalHistoryCommand(
        String background,
        String consultationReason,
        LocalDate consultationDate
) { }
