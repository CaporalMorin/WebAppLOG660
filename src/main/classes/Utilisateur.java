package classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;


public class Utilisateur {
    private int nosequence;
    private String nom;
    private String prenom;
    private String courriel;
    private String notelephone;
    private String motdepasse;
    private Time datenaissance;
    private Time actualDate;
    private Adresse adresse;

    public Utilisateur(){}
    public Utilisateur( int noSequence, String nom, String prenom, String courriel, String noTelephone, String motDePasse, Time  dateNaissance, Adresse adresse, Time actualDate){
        this.courriel = courriel;
        this.notelephone = noTelephone;
        this.motdepasse = motDePasse;
        this.datenaissance = dateNaissance;
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.nosequence = noSequence;
        this.actualDate = actualDate;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNosequence() {
        return nosequence;
    }

    public void setNosequence(int nosequence) {
        this.nosequence = nosequence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNotelephone() {
        return notelephone;
    }

    public void setNotelephone(String notelephone) {
        this.notelephone = notelephone;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Time getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Time datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Time getActualDate() {
        return actualDate;
    }

    public void setActualDate(Time actualDate) {
        this.actualDate = actualDate;
    }


}
