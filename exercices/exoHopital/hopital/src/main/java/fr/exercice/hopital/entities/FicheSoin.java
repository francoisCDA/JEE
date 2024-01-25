package fr.exercice.hopital.entities;

import javax.persistence.*;

@Entity
public class FicheSoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fiche_soin", nullable = false)
    private Long idFiche;

    @Column(name="type_de_soin")
    private String typeSoin;

    @Column(name="nb_jour")
    private int nbjour;

    @ManyToOne
    @JoinColumn(name = "consult_id")
    private Consultation consultation;


    public Long getIdFiche() {
        return idFiche;
    }

    public void setIdFiche(Long idFiche) {
        this.idFiche = idFiche;
    }

    public String getTypeSoin() {
        return typeSoin;
    }

    public void setTypeSoin(String typeSoin) {
        this.typeSoin = typeSoin;
    }

    public int getNbjour() {
        return nbjour;
    }

    public void setNbjour(int nbjour) {
        this.nbjour = nbjour;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
