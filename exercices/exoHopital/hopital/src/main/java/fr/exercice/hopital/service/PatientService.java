package fr.exercice.hopital.service;

import fr.exercice.hopital.dao.PatientDAO;
import fr.exercice.hopital.entities.Patient;

import java.time.LocalDate;
import java.util.List;

public class PatientService {

    private PatientDAO patientDAO;

    public PatientService() {
        patientDAO = new PatientDAO();
    }

    public void newPatient(String nom, String prenom, LocalDate naissance) {
        Patient patient = new Patient();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setNaissance(naissance);

        patientDAO.create(patient);

    }

    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    public void updPatient(Patient patient) {
        patientDAO.update(patient);
    }

    public void rmPatient(Long id) {
        patientDAO.remove(id);
    }

}