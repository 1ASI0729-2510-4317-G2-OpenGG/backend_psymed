package com.openGG.psymed.plattform.profiles.interfaces.rest.resources;

import com.openGG.psymed.plattform.profiles.domain.model.valueobjects.AccountId;

public record ProfileResource(
        Long id,
        String fullName,
        String email,
        String streetAddress,
        AccountId accountId,
        Long professionalId
) { }
