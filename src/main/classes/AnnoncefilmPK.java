package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AnnoncefilmPK implements Serializable {
    private String lien;
    private long nofilm;



    @Column(name = "LIEN", nullable = false, length = 1000)
    @Id
    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Column(name = "NOFILM", nullable = false, precision = 0)
    @Id
    public long getNofilm() {
        return nofilm;
    }

    public void setNofilm(long nofilm) {
        this.nofilm = nofilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnoncefilmPK that = (AnnoncefilmPK) o;

        if (nofilm != that.nofilm) return false;
        if (lien != null ? !lien.equals(that.lien) : that.lien != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lien != null ? lien.hashCode() : 0;
        result = 31 * result + (int) (nofilm ^ (nofilm >>> 32));
        return result;
    }
}
