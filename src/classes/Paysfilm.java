package classes;


public class Paysfilm {
    private String pays;
    private int nofilm;
    private Film filmByNofilm;

    public Paysfilm(){}

    public Paysfilm(String pays, int noFilm){
        this.pays = pays;
        this.nofilm = noFilm;
    }


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
