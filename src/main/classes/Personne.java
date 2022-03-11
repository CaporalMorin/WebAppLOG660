package main.classes;

import java.sql.Time;
import java.util.Collection;
import java.util.Set;


public class Personne {
    private int nopersonne;
    private String nom;
    private String photo;
    private String biographie;
    private Time datenaissance;
    private String lieunaissance;
    private Set personnagefilmsByNopersonne;

    public Personne(){}
    public Personne(int noPersonne, String nom, String photo, String bio, Time  dateNaissance, String lieuNaissance, Set collection) {
        this.nom = nom;
        this.photo = photo;
        this.biographie = bio;
        this.datenaissance = dateNaissance;
        this.lieunaissance = lieuNaissance;
        this.nopersonne = noPersonne;
        personnagefilmsByNopersonne = collection;
    }

    public int getNopersonne() {
        return nopersonne;
    }

    public void setNopersonne(int nopersonne) {
        this.nopersonne = nopersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }


    public Time getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Time datenaissance) {
        this.datenaissance = datenaissance;
    }


    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public Collection<Personnagefilm> getPersonnagefilmsByNopersonne() {
        return personnagefilmsByNopersonne;
    }

    public void setPersonnagefilmsByNopersonne(Set personnagefilmsByNopersonne) {
        this.personnagefilmsByNopersonne = personnagefilmsByNopersonne;
    }
}
