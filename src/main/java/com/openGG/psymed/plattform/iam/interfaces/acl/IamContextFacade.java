package com.openGG.psymed.plattform.iam.interfaces.acl;

import com.openGG.psymed.plattform.iam.domain.model.commands.SignUpCommand;
import com.openGG.psymed.plattform.iam.domain.model.queries.GetAccountByIdQuery;
import com.openGG.psymed.plattform.iam.domain.service.AccountCommandService;
import com.openGG.psymed.plattform.iam.domain.service.AccountQueryService;
import org.springframework.stereotype.Service;

@Service
public class IamContextFacade {
    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    public IamContextFacade(AccountCommandService accountCommandService,
                            AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }

    public Long createAccount (String username, String password, String role) {
        var signUpCommand = new SignUpCommand(username, password, role);
        var result = accountCommandService.handle(signUpCommand);
        if(result.isEmpty())
            throw new RuntimeException("Error creating account");
        return result.get().getId();
    }

    public String fetchUsernameByAccountId(Long accountId) {
        var getAccountByIdQuery = new GetAccountByIdQuery(accountId);
        var result = accountQueryService.handle(getAccountByIdQuery);
        if(result.isEmpty())
            throw new RuntimeException("Account not found");
        return result.get().getUserName();
    }
}
