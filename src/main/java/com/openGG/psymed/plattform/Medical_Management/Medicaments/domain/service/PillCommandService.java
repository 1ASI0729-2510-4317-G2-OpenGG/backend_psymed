package com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.service;

import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.commands.CreatePillsCommand;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.commands.DeletePillsCommand;

public interface PillCommandService {
    Long handle (CreatePillsCommand command);

    void handle (DeletePillsCommand command);
}