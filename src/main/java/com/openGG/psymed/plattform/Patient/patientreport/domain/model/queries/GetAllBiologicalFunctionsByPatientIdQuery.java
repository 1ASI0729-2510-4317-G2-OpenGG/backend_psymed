package com.openGG.psymed.plattform.Patient.patientreport.domain.model.queries;


import com.openGG.psymed.plattform.Patient.patientreport.domain.model.valueobjects.PatientId;

public record GetAllBiologicalFunctionsByPatientIdQuery(PatientId patientId) {
    public GetAllBiologicalFunctionsByPatientIdQuery {
        if(patientId.patientId() < 0) {
            throw new IllegalArgumentException("PatientId must be greater than 0");
        }
    }
}
