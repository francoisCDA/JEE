package fr.exercice.exoproduit.dao;

import fr.exercice.exoproduit.service.SessionFactoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class BaseDAO {

    protected SessionFactory factory;

    protected Session session;


    public BaseDAO() {
        factory = SessionFactoryService.get();
    }





}
