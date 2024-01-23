package fr.exercice.exoproduit.dao;

import fr.exercice.exoproduit.models.User;
import org.hibernate.Session;

import java.util.List;

public class UsersDAO extends BaseDAO implements DAO<User> {

    @Override
    public void create(User obj) {

        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
        } catch (Exception ignored) {

        } finally {
            session.close();
        }
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void remove(Long id) {

    }
}
