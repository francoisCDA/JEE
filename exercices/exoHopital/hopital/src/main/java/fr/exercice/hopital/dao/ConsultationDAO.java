package fr.exercice.hopital.dao;

import fr.exercice.hopital.entities.Consultation;
import fr.exercice.hopital.entities.Prescription;
import org.hibernate.query.Query;

import java.util.List;

public class ConsultationDAO extends BaseDAO implements DAO<Consultation> {
    @Override
    public void create(Consultation obj) {
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
    public Consultation get(Long id) {
        try {
            Consultation ret = lazysession.get(Consultation.class,id);
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public List<Consultation> getAll() {
        try {
            Query<Consultation> patientQuery = lazysession.createQuery("from Consultation");
            List<Consultation> ret = patientQuery.list();
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public void update(Consultation obj) {

    }

    @Override
    public void remove(Long id) {

    }
}
