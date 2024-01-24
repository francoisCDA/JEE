package fr.exercice.exoproduit.service;

import fr.exercice.exoproduit.dao.UsersDAO;
import fr.exercice.exoproduit.models.User;

public class UserService {

    private UsersDAO userDAO;

    public UserService() {
        userDAO = new UsersDAO();
    }

    public void create(String pseudo, String passwd) {
        User newUser = new User();

        newUser.setPswd(passwd);
        newUser.setPseudo(pseudo);

        userDAO.create(newUser);

    }

    public User get(String pseud,String paswd) {
        return userDAO.get(pseud, paswd);
    }


}
