package classes;

public class Genrefilm {
    private int nofilm;
    private String genre;
    private Film filmByNofilm;

    public Genrefilm(){}

    public Genrefilm(String genre, int noFilm){
        this.genre = genre;
        this.nofilm = noFilm;
    }

    public int getNofilm() {
        return nofilm;
    }

    public void setNofilm(int nofilm) {
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
