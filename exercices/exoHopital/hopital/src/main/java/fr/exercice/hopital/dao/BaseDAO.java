package fr.exercice.hopital.dao;


import fr.exercice.hopital.service.SessionFactoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class BaseDAO {

    protected SessionFactory factory;

    protected Session session;

    protected Session lazysession;

    public BaseDAO() {
        factory = SessionFactoryService.get();
        lazysession = factory.openSession();
    }



}
