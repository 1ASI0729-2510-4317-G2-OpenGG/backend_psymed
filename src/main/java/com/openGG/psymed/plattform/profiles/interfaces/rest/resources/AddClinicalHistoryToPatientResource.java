package com.openGG.psymed.plattform.profiles.interfaces.rest.resources;

import java.time.LocalDate;

public record AddClinicalHistoryToPatientResource(String background, String consultationReason, LocalDate consultationDate) {
}
