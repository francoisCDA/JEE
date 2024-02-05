package org.example.test2.service;


import org.example.exoapirest.entity.Task;

import java.util.List;

public interface TaskService {

    Task save(String content);

    boolean delete(int id);

    boolean updateStatus(int id);

    List<Task> getAll();


}
