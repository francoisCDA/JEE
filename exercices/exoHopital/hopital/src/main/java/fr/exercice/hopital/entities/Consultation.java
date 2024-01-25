package fr.exercice.hopital.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consult", nullable = false)
    private Long idConsult;

    private LocalDate date;

    private String medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FicheSoin> fichesSoins;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptions;

    public Patient getPatient() {
        return patient;
    }



    public Long getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(Long idConsult) {
        this.idConsult = idConsult;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<FicheSoin> getFichesSoins() {
        return fichesSoins;
    }

    public void setFichesSoins(List<FicheSoin> fichesSoins) {
        this.fichesSoins = fichesSoins;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
