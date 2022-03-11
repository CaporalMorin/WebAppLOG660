package classes;

import javax.persistence.*;


public class Paysfilm {
    private String pays;
    private long nofilm;
    private Film filmByNofilm;

    public Paysfilm(){}
    public Paysfilm(String pays, Film noFilm){
        this.pays = pays;
        this.filmByNofilm = noFilm;
    }


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
