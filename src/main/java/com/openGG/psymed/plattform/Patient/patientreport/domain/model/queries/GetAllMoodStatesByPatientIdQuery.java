package com.openGG.psymed.plattform.Patient.patientreport.domain.model.queries;


import com.openGG.psymed.plattform.Patient.patientreport.domain.model.valueobjects.PatientId;

public record GetAllMoodStatesByPatientIdQuery(PatientId patientId) {
    public GetAllMoodStatesByPatientIdQuery {
        if(patientId.patientId() < 0) {
            throw new IllegalArgumentException("PatientId must be greater than 0");
        }
    }
}
