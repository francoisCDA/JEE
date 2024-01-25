package fr.exercice.hopital.entities;

import javax.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presc", nullable = false)
    private Long idPresc;


    private String medicament;

    private String posologie;

    @ManyToOne
    @JoinColumn(name = "consult_id")
    private Consultation consultation;




    public Long getIdPresc() {
        return idPresc;
    }

    public void setIdPresc(Long idPresc) {
        this.idPresc = idPresc;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
