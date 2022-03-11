package classes;

import javax.persistence.*;


public class Scenaristefilm {
    private String nom;
    private long nofilm;
    private Film filmByNofilm;

    public Scenaristefilm(){}
    public Scenaristefilm( Film noFilm, String nom){
        this.filmByNofilm = noFilm;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNofilm() {
        return nofilm;
    }

    public void setNofilm(long nofilm) {
        this.nofilm = nofilm;
    }

    public Film getFilmByNofilm() {
        return filmByNofilm;
    }

    public void setFilmByNofilm(Film filmByNofilm) {
        this.filmByNofilm = filmByNofilm;
    }
}
