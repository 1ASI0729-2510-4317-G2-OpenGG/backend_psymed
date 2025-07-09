package com.openGG.psymed.plattform.Patient_Management.patientreport.domain.services;



import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.aggregates.BiologicalFunction;
import com.openGG.psymed.plattform.Patient_Management.patientreport.domain.model.commands.CreateBiologicalFunctionRecordCommand;

import java.util.Optional;

public interface BiologicalFunctionCommandService {
    Optional<BiologicalFunction> handle(CreateBiologicalFunctionRecordCommand command);
}
