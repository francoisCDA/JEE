package fr.exercice.exoproduit.dao;


import fr.exercice.exoproduit.models.Produit;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ProduitDAO extends BaseDAO implements DAO<Produit>{


    @Override
    public void create(Produit produit) {

        update(produit);

    }

    @Override
    public Produit get(Long id) {
        Session session = factory.openSession();
      //  session.beginTransaction();

        try {
            Produit ret = session.get(Produit.class,id);
            return ret;
        } catch (Exception ignored) {
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List<Produit> getAll() {
        Session session = factory.openSession();
       // session.beginTransaction();

        try {
            Query<Produit> produitsQuery = session.createQuery("from Produit ");

            List<Produit> ret = produitsQuery.list();

            return ret;

        } catch (Exception ignored){
            return null;
        } finally {
            session.close();
        }


    }

    @Override
    public void update(Produit produit) {

        Session session = factory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(produit);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void remove(Long id) {

        Session session = factory.openSession();
        session.beginTransaction();

        Produit toRemove = session.load(Produit.class,id);

        session.delete(toRemove);

        session.getTransaction().commit();
        session.close();

    }

    public List<Produit> betweenDates(LocalDate start,LocalDate end){
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("from Produit where dateAchat > :start and dateAchat < :end");
        query.setParameter("start",start);
        query.setParameter("end",end);

        List<Produit> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;
    }

    public List<Produit> getPrdctPriceOver(Double prixMin) {

        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("from Produit where prix > :prix ");
        query.setParameter("prix",prixMin);

        List<Produit> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;
    }

    public List<Produit> getPrdctFilterByStock(int stock){
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("from Produit where stock < :stock ");
        query.setParameter("stock",stock);

        List<Produit> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;
    }

    public List<Produit> getPrdctFilterByMarque(String trade){
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("from Produit where marque = :marque ");
        query.setParameter("marque",trade);

        List<Produit> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;
    }


    public Double getAVGPrice(){
        Session session = factory.openSession();
        session.beginTransaction();

        double ret = (double) session.createQuery("select avg(prix) from Produit").uniqueResult();

        session.getTransaction().commit();
        session.close();

        return ret;
    }

    public void rmPrdctByMarque(String trade){
        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("delete Produit where marque = :marque ");
        query.setParameter("marque",trade);

        query.executeUpdate();

        session.getTransaction().commit();
        session.close();

    }


    public List<String> getTradeNames(){
        Session session = factory.openSession();
        session.beginTransaction();

        Query<String> query = session.createQuery("select distinct marque from Produit");
        List<String> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;

    }


    public List<Produit> getPrdctFromTrade(String trade) {

        Session session = factory.openSession();
        session.beginTransaction();

        Query<Produit> query = session.createQuery("from Produit where marque = :marque");
        query.setParameter("marque", trade);

        List<Produit> ret = query.list();

        session.getTransaction().commit();
        session.close();

        return ret;

    }

    public List<Produit> getByProdctScore(int minScore){

        session = factory.openSession();
        session.beginTransaction();

        try {
            String sql = "select p from Produit p join p.avis a group by p having avg(a.note) >= :score";
            Query<Produit> query = session.createQuery(sql, Produit.class);
            query.setParameter("score",minScore);

            return query.getResultList();

        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }







}
