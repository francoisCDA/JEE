package fr.exercice.hopital.dao;

import fr.exercice.hopital.entities.Prescription;
import org.hibernate.query.Query;

import java.util.List;

public class PrescriptionDAO extends BaseDAO implements DAO<Prescription> {
    @Override
    public void create(Prescription obj) {
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
    public Prescription get(Long id) {
        try {
            Prescription ret = lazysession.get(Prescription.class,id);
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public List<Prescription> getAll() {
        try {
            Query<Prescription> patientQuery = lazysession.createQuery("from Prescription");
            List<Prescription> ret = patientQuery.list();
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public void update(Prescription obj) {

    }

    @Override
    public void remove(Long id) {

    }
}
