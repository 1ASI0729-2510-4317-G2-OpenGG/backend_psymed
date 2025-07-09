package com.openGG.psymed.plattform.iam.domain.service;

import com.openGG.psymed.plattform.iam.domain.model.aggregate.Account;
import com.openGG.psymed.plattform.iam.domain.model.commands.SignInCommand;
import com.openGG.psymed.plattform.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface AccountCommandService {
    Optional<Account> handle (SignUpCommand command);
    Optional<ImmutablePair<Account, String>> handle(SignInCommand command);
}
