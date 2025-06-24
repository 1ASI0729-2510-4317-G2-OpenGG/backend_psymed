package com.openGG.psymed.plattform.profiles_management.domain.service;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.CreatePatientCommand;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.DeletePatientCommand;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.UpdatePatientCommand;

public interface PatientCommandService {
    Long handle(CreatePatientCommand command);

    void handle(DeletePatientCommand command);

    void handle(UpdatePatientCommand command);


}
