package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.TaskViewResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Anti-Corruption Layer (ACL) component responsible for fetching tasks assigned
 * to a patient from the external task management context.
 *
 * <p>This facade encapsulates communication logic to protect the internal domain
 * from changes in the external task service API.</p>
 */

@Component
public class TaskContextFacade {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/api/v1/tasks/patient";

    public TaskContextFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TaskViewResource> getTasksByPatientId(Long patientId) {
        String url = baseUrl + "/" + patientId;
        TaskViewResource[] response = restTemplate.getForObject(url, TaskViewResource[].class);
        return Arrays.asList(response);
    }
}