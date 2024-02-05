package org.example.exoapirest.repository;

import org.example.exoapirest.entity.Task;

import java.util.List;

public class TaskRepository extends Repository<Task>{
    @Override
    public Task findById(int id) {
        return session.get(Task.class,id);
    }

    @Override
    public List<Task> findAll() {
        return session.createQuery("from Task").list();
    }
}
