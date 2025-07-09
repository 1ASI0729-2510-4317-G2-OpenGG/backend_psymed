package com.openGG.psymed.plattform.Patient.patientreport.interfaces.rest.resources;

public record BiologicalFunctionResource(Long id, Integer hunger,
                                         Integer hydration, Integer sleep,
                                         Integer energy) {

}
