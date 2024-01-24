package fr.exercice.exoproduit.servlet;

import fr.exercice.exoproduit.models.User;
import fr.exercice.exoproduit.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "user", value ="/user")
public class UserServlet extends HelloServlet {

    private UserService userServ;

    @Override
    public void init() {
        userServ = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String pseudo = req.getParameter("pseudo");
        String passwd = req.getParameter("passwd");

        if (action.equals("register")) {
            userServ.create(pseudo,passwd);

            resp.sendRedirect("register.jsp");

        } else {

            User user = userServ.get(pseudo, passwd);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("estConnu", "in connexion we trust");
                resp.sendRedirect("produits");
            } else {
                resp.sendRedirect("identification-error.jsp");
            }

        }

    }
}
