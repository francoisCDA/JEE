package fr.exercice.hopital.servlet;

import fr.exercice.hopital.dao.AdminDAO;
import fr.exercice.hopital.entities.Patient;
import fr.exercice.hopital.service.AdminService;
import fr.exercice.hopital.service.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {

    private PatientService patientServ;

    private List<Patient> patientList;

    private final String viewPath = "/WEB-INF/views/";

    @Override
    public void init() throws ServletException {
        patientServ = new PatientService();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doGet(req, resp); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String action = req.getServletPath();

        try {
            switch (action) {
                case "/patients" -> listPatients(req, resp);
                case "/dossier" -> dossier(req,resp);
                case "/addpatient" -> addPatient(req,resp);
                case "/insert" -> insertPatient(req,resp);
                case "/consultation" -> consultation(req,resp);
                case "/chekadmin" -> checkadmin(req,resp);
            }


        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }





    private void dossier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void checkadmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String identifiant = req.getParameter("login");
            String passwd = req.getParameter("password");

        AdminService adserv = new AdminService();

        boolean isAdmin = adserv.isAdmin(identifiant,passwd);

        if  (isAdmin) {
            HttpSession session = req.getSession();
            session.setAttribute("admin",true);
            addPatient(req,resp);

        }else {
            resp.sendRedirect(viewPath+"error.jsp");
        }


    }

    private void addPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean isAdmin = session.getAttribute("admin")!=null ;

        if (isAdmin){
            resp.sendRedirect(viewPath+"formpatient.jsp");
        } else {
            resp.sendRedirect(viewPath+"identification.jsp");
        }


    }

    private void insertPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        LocalDate naissance = LocalDate.parse(req.getParameter("naissance"));

        Part photoPart = req.getPart("photo");
        //String fileType = photoPart.getContentType();

        byte[] photo = null;

        if (photoPart != null) {
            InputStream inputStream = photoPart.getInputStream();
            photo = inputStream.readAllBytes();
        }

        patientServ.newPatient(nom,prenom,naissance,photo);

        listPatients(req,resp);

    }

    private void consultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



    private void listPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientList = patientServ.getAll();
        req.setAttribute("patients",patientList);
        req.getRequestDispatcher(viewPath+"patients.jsp").forward(req,resp);

    }


}
