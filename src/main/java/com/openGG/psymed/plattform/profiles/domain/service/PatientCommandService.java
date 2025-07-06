package com.openGG.psymed.plattform.profiles.domain.service;
import com.openGG.psymed.plattform.profiles.domain.model.commands.CreatePatientCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.DeletePatientCommand;
import com.openGG.psymed.plattform.profiles.domain.model.commands.UpdatePatientCommand;

public interface PatientCommandService {
    Long handle(CreatePatientCommand command);

    void handle(DeletePatientCommand command);

    void handle(UpdatePatientCommand command);


}
