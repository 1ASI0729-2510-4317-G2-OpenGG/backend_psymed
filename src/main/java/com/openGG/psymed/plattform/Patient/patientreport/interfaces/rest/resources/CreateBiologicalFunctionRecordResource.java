package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources;

public record CreateBiologicalFunctionRecordResource(Integer hunger,
                                                     Integer hydration, Integer sleep,
                                                     Integer energy) {
}
