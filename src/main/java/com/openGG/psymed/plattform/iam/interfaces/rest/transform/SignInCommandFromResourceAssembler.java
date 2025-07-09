package com.openGG.psymed.plattform.iam.interfaces.rest.transform;

import com.openGG.psymed.plattform.iam.domain.model.commands.SignInCommand;
import com.openGG.psymed.plattform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
