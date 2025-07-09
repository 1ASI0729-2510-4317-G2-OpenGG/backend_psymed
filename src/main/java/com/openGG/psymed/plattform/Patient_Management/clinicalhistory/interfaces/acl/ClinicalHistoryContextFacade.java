package com.openGG.psymed.plattform.Patient_Management.clinicalhistory.interfaces.acl;

import java.time.LocalDate;

public interface ClinicalHistoryContextFacade {
    public long createClinicalHistory(String background, String consultationReason, LocalDate consultationDate);
}
