package com.example.todolist.service;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.util.HibernateSession;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.Session;

@ApplicationScoped
public class TodoService {

    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoDto.toEntity();
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            todoRepository.create(todo);
            session.getTransaction().commit();
            return todo.toDto();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public TodoDto updateTodo(int todoId) {

        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            Todo todo = todoRepository.findById(todoId);
            todo.setStatus(!todo.isStatus());
            todoRepository.update(todo);
            session.getTransaction().commit();
            return todo.toDto();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    public String getById(int id) {

        Session session = HibernateSession.getSessionFactory().openSession();

        todoRepository.setSession(session);
        try {
            return todoRepository.findById(id).toDto().toString();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }
    }

    public String getAll() {
        Session session = HibernateSession.getSessionFactory().openSession();

        todoRepository.setSession(session);
        try {
            return todoRepository.findAll().toString();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            session.close();
        }
    }

    public String delete(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            Todo todo = todoRepository.findById(id);
            todoRepository.delete(todo);
            session.getTransaction().commit();
            return "todo deleted";
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
