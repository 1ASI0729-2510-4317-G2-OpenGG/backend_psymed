package com.openGG.psymed.plattform.iam.interfaces.rest.transform;

import com.openGG.psymed.plattform.iam.domain.model.aggregate.Account;
import com.openGG.psymed.plattform.iam.interfaces.rest.resources.AuthenticatedAccountResource;

public class AuthenticatedAccountResourceFromEntityAssembler {
    //TODO: Implement token in the future
    public static AuthenticatedAccountResource toResourceFromEntity(Account entity, String token) {
        return new AuthenticatedAccountResource(entity.getId(), entity.getRoleInString(), token);
    }
}
