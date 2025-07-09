package com.openGG.psymed.plattform.Patient.patientreport.domain.services;



import com.openGG.psymed.plattform.Patient.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient.patientreport.domain.model.commands.CreateBiologicalFunctionRecordCommand;

import java.util.Optional;

public interface BiologicalFunctionCommandService {
    Optional<BiologicalFunction> handle(CreateBiologicalFunctionRecordCommand command);
}
