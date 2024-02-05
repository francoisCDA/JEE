package com.example.todolist.resource;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("todos")
public class TodoResource {

    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    public String get() {
        return todoService.getAll();
    }

    @GET
    @Path("{id}")
    public String get(@PathParam("id") int id) {
        return todoService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoDto post(TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PATCH
    @Path("{id}")
    public String patchStatus(@PathParam("id") int id) {
        return todoService.updateTodo(id).toString();
    }

    @DELETE
    @Path("{id}")
    public String delete(@PathParam("id") int id) {
        return todoService.delete(id);
    }
}
