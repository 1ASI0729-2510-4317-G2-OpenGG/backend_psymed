package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.ScheduleViewResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Anti-Corruption Layer (ACL) component responsible for interacting with the
 * external Medical Schedule context. It fetches schedules for a given patient
 * by making HTTP requests to the medical-schedule service.
 */

@Component
public class MedicalScheduleContextFacade {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/api/v1/schedules/patient";

    public MedicalScheduleContextFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ScheduleViewResource> getSchedulesByPatientId(Long patientId) {
        String url = baseUrl + "/" + patientId;
        ScheduleViewResource[] response = restTemplate.getForObject(url, ScheduleViewResource[].class);
        return Arrays.asList(response);
    }
}