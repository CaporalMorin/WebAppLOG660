package classes;


public class Scenaristefilm {
    private String nom;
    private int nofilm;
    private Film filmByNofilm;

    public Scenaristefilm(){}
    public Scenaristefilm(int noFilm, String nom){
        this.nofilm = noFilm;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNofilm() {
        return nofilm;
    }

    public void setNofilm(int nofilm) {
        this.nofilm = nofilm;
    }

    public Film getFilmByNofilm() {
        return filmByNofilm;
    }

    public void setFilmByNofilm(Film filmByNofilm) {
        this.filmByNofilm = filmByNofilm;
    }
}
