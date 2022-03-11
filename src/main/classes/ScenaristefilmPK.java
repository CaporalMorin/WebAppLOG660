package classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ScenaristefilmPK implements Serializable {
    private String nom;
    private long nofilm;

    @Column(name = "NOM", nullable = false, length = 200)
    @Id
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

        ScenaristefilmPK that = (ScenaristefilmPK) o;

        if (nofilm != that.nofilm) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (int) (nofilm ^ (nofilm >>> 32));
        return result;
    }
}
