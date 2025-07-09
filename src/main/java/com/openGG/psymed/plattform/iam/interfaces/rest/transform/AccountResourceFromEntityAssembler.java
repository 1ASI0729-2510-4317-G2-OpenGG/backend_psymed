package com.openGG.psymed.plattform.iam.interfaces.rest.transform;

import com.openGG.psymed.plattform.iam.domain.model.aggregate.Account;
import com.openGG.psymed.plattform.iam.interfaces.rest.resources.AccountResource;

public class AccountResourceFromEntityAssembler {
    public static AccountResource toResourceFromEntity(Account entity) {
        return new AccountResource(entity.getId(), entity.getUserName(), entity.getRoleInString());
    }
}
