package com.openGG.psymed.plattform.Medics.tasks.domain.service;


import com.openGG.psymed.plattform.Medics.tasks.domain.model.aggregates.Tasks;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.queries.GetAllTasksQuery;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.queries.GetTaskByTitleQuery;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.queries.GetTasksByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TaskQueryService {

    Optional<Tasks> handle(GetTaskByTitleQuery query);

    List<Tasks> handle(GetAllTasksQuery query);

    Optional<Tasks> handle(GetTasksByIdQuery getPillsByIdQuery);}
