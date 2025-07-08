package com.openGG.psymed.plattform.Medical_Management.medic_sections.infrastructure.acl.external.profiles;

/**
 * ACL (Anti-Corruption Layer) interface for accessing profile-related data from the Profiles context.
 * Used to retrieve a medic's ID using their email address.
 */
public interface ProfileContextFacade {

    /**
     * Retrieves the ID of a medic based on their email address.
     *
     * @param email the medic's email address
     * @return the medic's ID
     * @throws RuntimeException if no medic is found with the given email
     */
    Long getMedicIdByEmail(String email);
}
