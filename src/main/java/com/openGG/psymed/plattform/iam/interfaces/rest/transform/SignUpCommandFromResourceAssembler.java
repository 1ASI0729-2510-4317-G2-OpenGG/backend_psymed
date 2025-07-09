package com.openGG.psymed.plattform.iam.interfaces.rest.transform;

import com.openGG.psymed.plattform.iam.domain.model.commands.SignUpCommand;
import com.openGG.psymed.plattform.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.role());
    }
}
