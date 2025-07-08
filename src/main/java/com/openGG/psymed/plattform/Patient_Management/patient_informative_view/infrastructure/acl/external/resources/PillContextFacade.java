package com.openGG.psymed.plattform.Patient_Management.patient_informative_view.infrastructure.acl.external.resources;

import com.openGG.psymed.plattform.Patient_Management.patient_informative_view.interfaces.rest.resources.PillViewResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Anti-Corruption Layer (ACL) component that connects the patient informative view context
 * with the external medication context to retrieve pill data.
 *
 * <p>This class isolates the internal domain from external APIs by mapping and encapsulating
 * data from the medication module/service.</p>
 */

@Component
public class PillContextFacade {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/api/v1/pills/patient";

    public PillContextFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PillViewResource> getPillsByPatientId(Long patientId) {
        String url = baseUrl + "/" + patientId;
        PillViewResource[] response = restTemplate.getForObject(url, PillViewResource[].class);
        return Arrays.asList(response);
    }
}