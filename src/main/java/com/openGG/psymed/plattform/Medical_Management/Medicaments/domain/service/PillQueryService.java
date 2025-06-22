package com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.service;


import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.aggregates.Pills;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.queries.GetAllPillsQuery;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.queries.GetPillByNameQuery;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.queries.GetPillsByIdQuery;
import com.openGG.psymed.plattform.Medical_Management.Medicaments.domain.model.queries.GetPillsByPatientId;

import java.util.List;
import java.util.Optional;

public interface PillQueryService {

    Optional<Pills> handle(GetPillByNameQuery query);

    List<Pills> handle(GetAllPillsQuery query);

    Optional<Pills> handle(GetPillsByIdQuery getPillsByIdQuery);

    List<Pills> handle(GetPillsByPatientId getPillsByPatientId);
}
