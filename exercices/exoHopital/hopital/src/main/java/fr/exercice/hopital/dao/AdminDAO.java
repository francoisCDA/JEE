package fr.exercice.hopital.dao;

import fr.exercice.hopital.entities.Admin;
import fr.exercice.hopital.entities.Patient;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDAO extends BaseDAO implements DAO<Admin>{

    @Override
    public void create(Admin obj) {

    }

    @Override
    public Admin get(Long id) {
        return null;
    }

    public Admin idAdmin(String identifiant, String mdp) {

        session = factory.openSession();

        try {
            Query<Admin> query = session.createQuery("from Admin where identifiant = :ident and motDePasse = : mdp");
            query.setParameter("ident",identifiant);
            query.setParameter("mdp",mdp);

            return query.uniqueResult();

        } catch (Exception ignored) {
            return null;
        } finally {
            session.close();
        }

    }


    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public void update(Admin obj) {

    }

    @Override
    public void remove(Long id) {

    }
}
