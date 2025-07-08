package com.openGG.psymed.plattform.Medical_Management.medic_sections.application.internal.commandservices;

import com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.acl.external.profiles.ProfileContextFacade;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link ProfileContextFacade} interface used as an ACL
 * (Anti-Corruption Layer) to resolve a medic's ID based on their email address.
 *
 * <p>This implementation is temporary and hardcoded, simulating behavior until
 * a real IAM or profiles integration is in place.</p>
 */

@Component
public class ProfileContextFacadeImpl implements ProfileContextFacade {

    /**
     * Retrieves the medic ID based on their email address.
     * Currently, hardcoded for development purposes.
     *
     * @param email the medic's email
     * @return the corresponding medic ID
     * @throws RuntimeException if no matching medic is found
     */

    @Override
    public Long getMedicIdByEmail(String email) {
        if ("drjuan@gmail.com".equalsIgnoreCase(email)) return 1L;
        if ("draana@gmail.com".equalsIgnoreCase(email)) return 2L;
        throw new RuntimeException("Medic not found with email: " + email);
    }
}