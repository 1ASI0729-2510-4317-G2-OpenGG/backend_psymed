package com.openGG.psymed.plattform.profiles.domain.model.commands;

import java.time.LocalDate;

public record AddClinicalHistoryToPatientCommand(Long patientId,String background, String consultationReason, LocalDate consultationDate) {
}
