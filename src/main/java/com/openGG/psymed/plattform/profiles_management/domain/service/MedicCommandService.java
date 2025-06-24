package com.openGG.psymed.plattform.profiles_management.domain.service;
import com.openGG.psymed.plattform.profiles_management.domain.model.commands.*;

public interface MedicCommandService {
    Long handle(CreateMedicCommand command);

    void handle(DeleteMedicCommand command);

    void handle(UpdateMedicCommand command);


}
