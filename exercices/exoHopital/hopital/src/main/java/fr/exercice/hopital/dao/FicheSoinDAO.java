package fr.exercice.hopital.dao;

import fr.exercice.hopital.entities.FicheSoin;
import org.hibernate.query.Query;

import java.util.List;

public class FicheSoinDAO extends BaseDAO implements DAO<FicheSoin> {
    @Override
    public void create(FicheSoin obj) {
        session = factory.openSession();
        session.beginTransaction();

        try {
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
        } catch (Exception ignored){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public FicheSoin get(Long id) {
        try {
            FicheSoin ret = lazysession.get(FicheSoin.class,id);
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public List<FicheSoin> getAll() {
        try {
            Query<FicheSoin> patientQuery = lazysession.createQuery("from FicheSoin");
            List<FicheSoin> ret = patientQuery.list();
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public void update(FicheSoin obj) {

    }

    @Override
    public void remove(Long id) {

    }
}
