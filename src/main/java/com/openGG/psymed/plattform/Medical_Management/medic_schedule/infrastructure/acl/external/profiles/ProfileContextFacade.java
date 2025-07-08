package com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.acl.external.profiles;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Anti-Corruption Layer (ACL) component that acts as a bridge to the {@code profiles} context.
 * <p>
 * This facade is responsible for retrieving data from the {@code profiles} module,
 * specifically mapping a medic's email to their corresponding medic ID.
 * </p>
 */
@Component
public class ProfileContextFacade {

    private final RestTemplate restTemplate;

    /**
     * Constructs a new {@code ProfileContextFacade} with the given {@link RestTemplate}.
     *
     * @param restTemplate the {@code RestTemplate} used for HTTP communication with the profiles context
     */
    public ProfileContextFacade(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves the medic's ID from the profiles context by their email.
     *
     * @param email the medic's email address
     * @return the unique identifier (ID) of the medic
     */
    public Long getMedicIdFromEmail(String email) {
        var uri = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/api/v1/medics/by-email")
                .queryParam("email", email)
                .build()
                .toUri();

        var response = restTemplate.getForObject(uri, MedicResource.class);
        return response.id();
    }

    /**
     * Record class that represents the structure of the medic resource returned
     * by the profiles' context.
     *
     * @param id        the unique identifier of the medic
     * @param name      the medic's first name
     * @param lastName  the medic's last name
     * @param email     the medic's email address
     * @param specialty the medic's area of specialization
     */
    public record MedicResource(Long id, String name, String lastName, String email, String specialty) {}
}