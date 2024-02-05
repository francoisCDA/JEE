package org.example.test2.repository;



import org.example.test2.entity.Task;

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
