package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.application.internal.queryservices;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.domain.model.queries.GetTasksByPatientIdQuery;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources.TaskContextFacade;
import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.TaskViewResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application service that handles the retrieval of patient-related tasks.
 * Uses a context facade to access task data from an external or decoupled module.
 */

@Service
public class ViewPatientTasksQueryService {

    private final TaskContextFacade taskContext;

    public ViewPatientTasksQueryService(TaskContextFacade taskContext) {
        this.taskContext = taskContext;
    }

    public List<TaskViewResource> handle(GetTasksByPatientIdQuery query) {
        return taskContext.getTasksByPatientId(query.patientId()).stream()
                .map(task -> new TaskViewResource(
                        task.id(),
                        task.title(),
                        task.description(),
                        task.status(),
                        task.patientId()
                )).toList();
    }
}