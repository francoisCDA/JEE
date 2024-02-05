package org.example.exoapirest.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.exoapirest.entity.Task;
import org.example.exoapirest.repository.TaskRepository;
import org.example.exoapirest.util.HibernateSession;
import org.hibernate.SessionFactory;


import java.util.List;

@ApplicationScoped
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final SessionFactory sessionFactory;

    @Inject
    public TaskServiceImpl(TaskRepository taskRepository, SessionFactory sessionFactory) {
        this.taskRepository = taskRepository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Task save(String content) {
        Task newTask = Task.builder().content(content).build();
        taskRepository.setSession(sessionFactory.openSession());
        return taskRepository.save(newTask);
    }

    @Override
    public boolean delete(int id) {
        taskRepository.setSession(sessionFactory.openSession());
        Task tache = taskRepository.findById(id);
        boolean ret = false;
        try {
            taskRepository.delete(tache);
            ret = true;
        } catch (Exception er) {

        }
        taskRepository.getSession().close();
        return ret;
    }

    @Override
    public boolean updateStatus(int id) {
        taskRepository.setSession(sessionFactory.openSession());
        Task tache = taskRepository.findById(id);
        tache.setStatus(true);
        boolean ret = false;
        try {
            taskRepository.update(tache);
            ret = true;
        } catch (Exception e) {

        }
        taskRepository.getSession().close();
        return ret;
    }

    @Override
    public List<Task> getAll() {
        taskRepository.setSession(taskRepository.getSession());
        List<Task> ret = taskRepository.findAll();
        taskRepository.getSession().close();
        return ret;
    }
}
