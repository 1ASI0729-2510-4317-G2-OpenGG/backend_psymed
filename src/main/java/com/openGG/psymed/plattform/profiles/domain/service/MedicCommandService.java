package com.openGG.psymed.plattform.profiles.domain.service;
import com.openGG.psymed.plattform.profiles.domain.model.commands.*;

public interface MedicCommandService {
    Long handle(CreateMedicCommand command);

    void handle(DeleteMedicCommand command);

    void handle(UpdateMedicCommand command);

    void handle(UpdateMedicDescriptionCommand command);
}
