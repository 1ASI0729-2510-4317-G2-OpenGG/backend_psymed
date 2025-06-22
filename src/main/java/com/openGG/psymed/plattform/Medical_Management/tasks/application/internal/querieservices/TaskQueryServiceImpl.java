package com.openGG.psymed.plattform.Medical_Management.tasks.application.internal.querieservices;

import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.aggregates.Tasks;
import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries.GetAllTasksQuery;
import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries.GetTaskByTitleQuery;
import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries.GetTasksByIdQuery;
import com.openGG.psymed.plattform.Medical_Management.tasks.domain.service.TaskQueryService;
import com.openGG.psymed.plattform.Medical_Management.tasks.infrastructure.persistence.jpa.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskQueryServiceImpl implements TaskQueryService {
    private final TaskRepository pillRepository;

    public TaskQueryServiceImpl(TaskRepository pillRepository) {
        this.pillRepository = pillRepository;
    }

    @Override
    public Optional<Tasks> handle(GetTaskByTitleQuery query) {
        return Optional.empty();
    }

    @Override
    public List<Tasks> handle(GetAllTasksQuery query) {

        return pillRepository.findAll();
    }

    @Override
    public Optional<Tasks> handle(GetTasksByIdQuery getTasksByIdQuery) {

        return pillRepository.findById(getTasksByIdQuery.taskId());
    }

}
