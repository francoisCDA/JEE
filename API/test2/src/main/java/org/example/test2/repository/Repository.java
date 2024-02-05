package org.example.test2.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session session;

    public Session getSession() {
        return session;
    }

    public Repository() {

    }

    public void setSession(Session session) {
        this.session = session;
    }


    public T save(T element) {
        session.beginTransaction();
        try {
            this.session.persist(element);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();

        } finally {
            session.close();
        }
        return element;
    }

    public void delete(T element) {
        session.remove(element);
    }

    public void update(T element) {
        session.persist(element);
    }

    public abstract T findById(int id);

    public abstract List<T> findAll();



}
