package fr.exercice.hopital.servlet;

import fr.exercice.hopital.dao.AdminDAO;
import fr.exercice.hopital.entities.Patient;
import fr.exercice.hopital.service.AdminService;
import fr.exercice.hopital.service.PatientService;
import fr.exercice.hopital.util.ViewPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hibernate.loader.plan.spi.BidirectionalEntityReference;

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
                case "/insert" -> insertPatient(req,resp);
                case "/consultation" -> consultation(req,resp);
                default -> listPatients(req,resp);
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void dossier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    private void insertPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean isAdmin = session.getAttribute("admin") != null ;

        if (isAdmin) {

            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            LocalDate naissance = LocalDate.parse(req.getParameter("naissance"));

            Part photoPart = req.getPart("photo");

            byte[] photo = null;

            if (photoPart != null) {
                InputStream inputStream = photoPart.getInputStream();
                photo = inputStream.readAllBytes();
            }

            patientServ.newPatient(nom, prenom, naissance, photo);

            listPatients(req, resp);
        } else {
            resp.sendRedirect("identification.jsp");
        }
    }


    private void consultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    private void listPatients(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientList = patientServ.getAll();
        req.setAttribute("patients",patientList);
        req.getRequestDispatcher(ViewPath.path + "patients.jsp").forward(req,resp);

    }


}
