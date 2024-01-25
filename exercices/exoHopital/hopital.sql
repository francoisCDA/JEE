/**********************************
TP hopital
**********************************/

CREATE DATABASE hopital;

use hopital;




CREATE TABLE `Admin`
(
    id_admin    BIGINT AUTO_INCREMENT NOT NULL,
    identifiant VARCHAR(255) NULL,
    motDePasse  VARCHAR(255) NULL,
    CONSTRAINT pk_admin PRIMARY KEY (id_admin)
);

CREATE TABLE Consultation
(
    id_consult BIGINT AUTO_INCREMENT NOT NULL,
    date       date NULL,
    medecin    VARCHAR(255) NULL,
    patient_id BIGINT NULL,
    CONSTRAINT pk_consultation PRIMARY KEY (id_consult)
);

CREATE TABLE FicheSoin
(
    id_fiche_soin BIGINT AUTO_INCREMENT NOT NULL,
    type_de_soin  VARCHAR(255) NULL,
    nb_jour       INT NULL,
    consult_id    BIGINT NULL,
    CONSTRAINT pk_fichesoin PRIMARY KEY (id_fiche_soin)
);

CREATE TABLE Patient
(
    id_patient BIGINT AUTO_INCREMENT NOT NULL,
    nom        VARCHAR(255) NULL,
    prenom     VARCHAR(255) NULL,
    naissance  date NULL,
    photo      BLOB NULL,
    CONSTRAINT pk_patient PRIMARY KEY (id_patient)
);

CREATE TABLE Prescription
(
    id_presc   BIGINT AUTO_INCREMENT NOT NULL,
    medicament VARCHAR(255) NULL,
    posologie  VARCHAR(255) NULL,
    consult_id BIGINT NULL,
    CONSTRAINT pk_prescription PRIMARY KEY (id_presc)
);

ALTER TABLE Consultation
    ADD CONSTRAINT FK_CONSULTATION_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES Patient (id_patient);

ALTER TABLE FicheSoin
    ADD CONSTRAINT FK_FICHESOIN_ON_CONSULT FOREIGN KEY (consult_id) REFERENCES Consultation (id_consult);

ALTER TABLE Prescription
    ADD CONSTRAINT FK_PRESCRIPTION_ON_CONSULT FOREIGN KEY (consult_id) REFERENCES Consultation (id_consult);
    
/****************************
	commande
*****************************/

-- creation d'un admin

 

insert into admin (identifiant, motDePasse) values ("DrMad","mesdoc");

