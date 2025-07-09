package com.openGG.psymed.plattform.Patient_Management.patientreport.domain.services;


import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.queries.GetAllBiologicalFunctionsByPatientIdQuery;

import java.util.List;

public interface BiologicalFunctionQueryService {
    List<BiologicalFunction> handle(GetAllBiologicalFunctionsByPatientIdQuery query);
}
