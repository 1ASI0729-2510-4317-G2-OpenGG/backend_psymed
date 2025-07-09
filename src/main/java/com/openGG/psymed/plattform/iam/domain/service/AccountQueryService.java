package com.openGG.psymed.plattform.iam.domain.service;

import com.openGG.psymed.plattform.iam.domain.model.aggregate.Account;
import com.openGG.psymed.plattform.iam.domain.model.queries.GetAccountByIdQuery;

import java.util.Optional;

public interface AccountQueryService {
    Optional<Account> handle(GetAccountByIdQuery query);
}
