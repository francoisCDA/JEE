package fr.exercice.hopital.service;

import fr.exercice.hopital.dao.AdminDAO;
import fr.exercice.hopital.entities.Admin;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService() {
        adminDAO = new AdminDAO();
    }

    public boolean isAdmin(String identifiant, String mdp) {

        Admin admin = adminDAO.idAdmin(identifiant, mdp);
        return (admin!=null);

    }



}
