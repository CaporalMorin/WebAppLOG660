package main.classes;

import javax.persistence.*;


public class Personnagefilm {
    private long nopersonnage;
    private String nom;
    private Film filmByNofilm;
    private Personne personneByNopersonne;

    public Personnagefilm(){

    }
    public Personnagefilm(int noPersonnage,  String nom, Personne personne){

        this.nopersonnage = noPersonnage;
        this.nom = nom;
        this.personneByNopersonne = personne;
    }

    public long getNopersonnage() {
        return nopersonnage;
    }

    public void setNopersonnage(long nopersonnage) {
        this.nopersonnage = nopersonnage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Film getFilmByNofilm() {
        return filmByNofilm;
    }

    public void setFilmByNofilm(Film filmByNofilm) {
        this.filmByNofilm = filmByNofilm;
    }

    public Personne getPersonneByNopersonne() {
        return personneByNopersonne;
    }

    public void setPersonneByNopersonne(Personne personneByNopersonne) {
        this.personneByNopersonne = personneByNopersonne;
    }
}
