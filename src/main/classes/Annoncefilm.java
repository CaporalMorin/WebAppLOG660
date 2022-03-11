package classes;

public class Annoncefilm {
    private String lien;
    private int nofilm;
    private Film filmByNofilm;

    public Annoncefilm(){

    }
    public Annoncefilm(String lien, Film noFilm){
        this.lien = lien;
        this.filmByNofilm=noFilm;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
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
