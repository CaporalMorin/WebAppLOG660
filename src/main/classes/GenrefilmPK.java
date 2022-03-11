package main.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GenrefilmPK implements Serializable {
    private long nofilm;
    private String genre;

    @Column(name = "NOFILM", nullable = false, precision = 0)
    @Id
    public long getNofilm() {
        return nofilm;
    }

    public void setNofilm(long nofilm) {
        this.nofilm = nofilm;
    }

    @Column(name = "GENRE", nullable = false, length = 100)
    @Id
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenrefilmPK that = (GenrefilmPK) o;

        if (nofilm != that.nofilm) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (nofilm ^ (nofilm >>> 32));
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
