package com.openGG.psymed.plattform.Patient.patientreport.domain.services;


import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.MoodState;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.queries.GetAllMoodStatesByPatientIdQuery;

import java.util.List;

public interface MoodStateQueryService {
    List<MoodState> handle(GetAllMoodStatesByPatientIdQuery query);
}
