package com.openGG.psymed.plattform.profiles_management.domain.service;

import com.openGG.psymed.plattform.profiles_management.domain.model.aggregates.Medic;
import com.openGG.psymed.plattform.profiles_management.domain.model.queries.*;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public interface MedicQueryService {

    List<Medic> handle(GetAllMedicsQuery query);

    Optional<Medic> handle(GetMedicByIdQuery query);

    Optional<Medic> handle(GetMedicByEmailQuery query);

    Optional<Medic> handle(GetMedicByNameQuery query);

    Optional<Medic> handle(GetMedicByLastNameQuery query);
}
