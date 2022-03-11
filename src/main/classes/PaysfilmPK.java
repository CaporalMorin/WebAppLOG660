package main.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PaysfilmPK implements Serializable {
    private String pays;
    private long nofilm;

    @Column(name = "PAYS", nullable = false, length = 100)
    @Id
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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

        PaysfilmPK that = (PaysfilmPK) o;

        if (nofilm != that.nofilm) return false;
        if (pays != null ? !pays.equals(that.pays) : that.pays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pays != null ? pays.hashCode() : 0;
        result = 31 * result + (int) (nofilm ^ (nofilm >>> 32));
        return result;
    }
}
