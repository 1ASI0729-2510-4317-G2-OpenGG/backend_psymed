package com.openGG.psymed.plattform.Medics.tasks.domain.model.aggregates;

import com.openGG.psymed.plattform.Medics.tasks.domain.model.commands.CreateTasksCommand;
import com.openGG.psymed.plattform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
//@NoArgsConstructor
public class Tasks extends AuditableAbstractAggregateRoot<Tasks> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean status;


    // Constructor usando los campos correctos
    public Tasks(String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Constructor usando CreateTasksCommand
    public Tasks(CreateTasksCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.status = command.status();
    }
    public Tasks() {

    }
}