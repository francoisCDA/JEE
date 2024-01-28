package fr.exercice.hopital.dao;

import fr.exercice.hopital.entities.Patient;
import org.hibernate.query.Query;

import java.util.List;

public class PatientDAO extends BaseDAO implements DAO<Patient> {


    @Override
    public void create(Patient obj) {
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
    public Patient get(Long id) {
        try {
            Patient ret = lazysession.get(Patient.class,id);
            return ret;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public List<Patient> getAll() {
        session = factory.openSession();
        try {
            Query<Patient> patientQuery = session.createQuery("from Patient");
            List<Patient> ret = patientQuery.list();
            return ret;
        } catch (Exception ignored) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Patient obj) {
        create(obj);
    }

    @Override
    public void remove(Long id) {

    }
}
