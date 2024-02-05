package org.example.exoapirest.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exoapirest.entity.Task;
import org.example.exoapirest.repository.Repository;
import org.example.exoapirest.service.TaskService;
import org.example.exoapirest.service.TaskServiceImpl;

import java.util.List;

@Path("todo")
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
