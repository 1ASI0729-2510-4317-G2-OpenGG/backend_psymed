package com.openGG.psymed.plattform.medication_management.domain.service;

import com.openGG.psymed.plattform.medication_management.domain.model.commands.CreatePillsCommand;
import com.openGG.psymed.plattform.medication_management.domain.model.commands.DeletePillsCommand;

public interface PillCommandService {
    Long handle (CreatePillsCommand command);

    void handle (DeletePillsCommand command);
}