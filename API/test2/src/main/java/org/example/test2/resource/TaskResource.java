package org.example.test2.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.exoapirest.entity.Task;
import org.example.exoapirest.service.TaskService;
import org.example.exoapirest.service.TaskServiceImpl;

@Path("/todo")
public class TaskResource {

    private final TaskService taskService;

    @Inject
    public TaskResource(TaskServiceImpl taskService){
        this.taskService = taskService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Task postTask(@FormParam("content") String content){
        return taskService.save(content);
    }



}
