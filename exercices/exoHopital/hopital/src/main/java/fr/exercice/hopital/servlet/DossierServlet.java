package fr.exercice.hopital.servlet;

import fr.exercice.hopital.entities.Consultation;
import fr.exercice.hopital.entities.Patient;
import fr.exercice.hopital.service.PatientService;
import fr.exercice.hopital.util.ViewPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dossier")
public class DossierServlet extends HttpServlet {

    private PatientService patientService;

    private Patient patient;



    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idPatient = Long.parseLong(req.getParameter("id"));

        patient = patientService.get(idPatient);
        PhotoServlet.set(patient.getId(), patient.getPhoto());
        req.setAttribute("patient",patient);
        req.getRequestDispatcher(ViewPath.path+"dossier.jsp").forward(req,resp);


    }
}
