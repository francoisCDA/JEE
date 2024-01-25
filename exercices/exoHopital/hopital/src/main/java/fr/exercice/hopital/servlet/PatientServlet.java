package fr.exercice.hopital.servlet;

import fr.exercice.hopital.entities.Patient;
import fr.exercice.hopital.service.PatientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientList = patientServ.getAll();
        req.setAttribute("patients",patientList);
        req.getRequestDispatcher("/WEB-INF/views/patient.jsp").forward(req,resp);

    }
}
