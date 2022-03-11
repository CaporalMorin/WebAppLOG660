package classes;

import javax.persistence.*;

public class Genrefilm {
    private long nofilm;
    private String genre;
    private Film filmByNofilm;

    public Genrefilm(){}

    public Genrefilm(String genre, Film noFilm){
        this.genre = genre;
        this.filmByNofilm = noFilm;
    }

    public long getNofilm() {
        return nofilm;
    }

    public void setNofilm(long nofilm) {
        this.nofilm = nofilm;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Film getFilmByNofilm() {
        return filmByNofilm;
    }

    public void setFilmByNofilm(Film filmByNofilm) {
        this.filmByNofilm = filmByNofilm;
    }
}
