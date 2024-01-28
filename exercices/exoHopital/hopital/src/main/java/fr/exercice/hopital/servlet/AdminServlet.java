package fr.exercice.hopital.servlet;

import fr.exercice.hopital.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addpatient")
public class AdminServlet extends HttpServlet {

    private AdminService adServ;


    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean isAdmin = session.getAttribute("admin") != null ;

        if (isAdmin){
            resp.sendRedirect("formpatient.jsp");
        } else {
            resp.sendRedirect("identification.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        adServ = new AdminService();

        String identifiant = req.getParameter("login");
        String passwd = req.getParameter("password");

        boolean isAdmin = adServ.isAdmin(identifiant,passwd);

        if  (isAdmin) {
            HttpSession session = req.getSession();
            session.setAttribute("admin",true);
            resp.sendRedirect("formpatient.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }


}
