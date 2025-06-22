                package com.openGG.psymed.plattform.Medical_Management.tasks.interfaces;
                import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries.GetAllTasksQuery;
                import com.openGG.psymed.plattform.Medical_Management.tasks.domain.model.queries.GetTasksByIdQuery;
                import com.openGG.psymed.plattform.Medical_Management.tasks.domain.service.TaskCommandService;
                import com.openGG.psymed.plattform.Medical_Management.tasks.domain.service.TaskQueryService;
                import com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.resorces.CreateTaskResource;
                import com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.resorces.TaskResource;
                import com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.transform.CreateTaskCommandFromResourceAssembler;
                import com.openGG.psymed.plattform.Medical_Management.tasks.interfaces.rest.transform.TaskResourceFromEntityAssembler;
                import io.swagger.v3.oas.annotations.Operation;
                import io.swagger.v3.oas.annotations.responses.ApiResponse;
                import io.swagger.v3.oas.annotations.responses.ApiResponses;
                import io.swagger.v3.oas.annotations.tags.Tag;
                import org.springframework.http.HttpStatus;
                import org.springframework.http.ResponseEntity;
                import org.springframework.web.bind.annotation.*;

                import java.util.List;

                import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

                @RestController
                @RequestMapping(value = "/api/v1/tasks", produces = APPLICATION_JSON_VALUE)
                @Tag(name = "Task_management", description = "All task related endpoints")
                public class TaskController {

                    private final TaskCommandService taskCommandService;
                    private final TaskQueryService taskQueryService;

                    public TaskController(TaskCommandService taskCommandService, TaskQueryService taskQueryService) {
                        this.taskCommandService = taskCommandService;
                        this.taskQueryService = taskQueryService;
                    }

                    @Operation(summary = "Create a new Task")
                    @ApiResponses(value = {
                            @ApiResponse(responseCode = "201", description = "Task created"),
                            @ApiResponse(responseCode = "400", description = "Bad request"),
                            @ApiResponse(responseCode = "404", description = "Task not found")
                    })
                    @PostMapping
                    public ResponseEntity<TaskResource> createTask(@RequestBody CreateTaskResource createTaskResource) {
                        var createTaskCommand = CreateTaskCommandFromResourceAssembler.toCommandFromResource(createTaskResource);
                        var taskId = taskCommandService.handle(createTaskCommand);
                        if (taskId == null || taskId == 0L) return ResponseEntity.badRequest().build();
                        var getTaskByIdQuery = new GetTasksByIdQuery(taskId);
                        var task = taskQueryService.handle(getTaskByIdQuery);

                        if (task.isEmpty()) return ResponseEntity.notFound().build();
                        var taskEntity = task.get();
                        var taskResource = TaskResourceFromEntityAssembler.toResourceFromEntity(taskEntity);
                        return new ResponseEntity<>(taskResource, HttpStatus.CREATED);
                    }

                    @Operation(summary = "Get all Tasks")
                    @ApiResponses(value = {
                            @ApiResponse(responseCode = "200", description = "Tasks found"),
                            @ApiResponse(responseCode = "404", description = "Tasks not found")
                    })
                    @GetMapping
                    public ResponseEntity<List<TaskResource>> getAllTasks() {
                        var getAllTasksQuery = new GetAllTasksQuery();
                        var tasks = taskQueryService.handle(getAllTasksQuery);
                        var taskResources = tasks.stream()
                                .map(TaskResourceFromEntityAssembler::toResourceFromEntity)
                                .toList();
                        return ResponseEntity.ok(taskResources);
                    }
                }