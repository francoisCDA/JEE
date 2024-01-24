package fr.exercice.exoproduit.dao;

import fr.exercice.exoproduit.models.User;
import org.hibernate.Session;

import org.hibernate.query.Query;
import java.util.List;

public class UsersDAO extends BaseDAO implements DAO<User> {

    @Override
    public void create(User obj) {

        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public User get(Long id) {
        return null;
    }

    public User get(String pseudo, String passwd) {
        Session session = factory.openSession();

        try {
           Query<User> query = session.createQuery("from User where pseudo = :pseud and pswd = :passwd ");
           query.setParameter("pseud",pseudo);
           query.setParameter("passwd",passwd);

           return query.uniqueResult();

        } catch (Exception e) {
           return null;
        } finally {
            session.close();
        }

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
