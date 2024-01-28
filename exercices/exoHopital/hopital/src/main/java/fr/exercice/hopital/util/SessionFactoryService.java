package fr.exercice.hopital.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryService {

    private StandardServiceRegistry registry;

    private SessionFactory sessionFactory;

    private static SessionFactoryService instance;

    private static Session lazySession;


    private SessionFactoryService(){
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory get() {
        if (instance == null) {
            instance = new SessionFactoryService();
        }
        return instance.sessionFactory;
    }

    public static Session getLazySession(){
        if (lazySession == null) {
            lazySession = get().openSession();
        }
        return lazySession;
    }

    public static void close() {
        lazySession.close();
        instance.sessionFactory.close();
        instance = null;
    }


}
