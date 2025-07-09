package com.openGG.psymed.plattform.Medics.tasks.application.internal.commandservice;

import com.openGG.psymed.plattform.Medics.tasks.domain.model.aggregates.Tasks;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.commands.CreateTasksCommand;
import com.openGG.psymed.plattform.Medics.tasks.domain.model.commands.DeleteTaskCommand;
import com.openGG.psymed.plattform.Medics.tasks.domain.service.TaskCommandService;
import com.openGG.psymed.plattform.Medics.tasks.infrastructure.persistence.jpa.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskCommandServiceImpl implements TaskCommandService {

    private final TaskRepository taskRepository;

    public TaskCommandServiceImpl(TaskRepository pillRepository){
        this.taskRepository = pillRepository;
    }
    @Override
    public Long handle(CreateTasksCommand command) {
        if (taskRepository.existsByTitle(command.title()))
            throw new IllegalArgumentException("There is a medication with the same name");
        var medication = new Tasks(command);
        try {
            taskRepository.save(medication);
            return medication.getId();
        }catch(Exception e){
            throw new IllegalArgumentException(String.format("Error creating the medication %s", e.getMessage()));
        }
    }

    @Override
    public void handle(DeleteTaskCommand command) {
        if(!taskRepository.existsById(command.taskId()))
            throw new IllegalStateException("The medication doesn't exist");
        try {
            taskRepository.deleteById(command.taskId());
        } catch(Exception e)
        {
            throw new IllegalArgumentException("An error occurred during delete: %s".formatted(e.getMessage()));
        }
    }
}
