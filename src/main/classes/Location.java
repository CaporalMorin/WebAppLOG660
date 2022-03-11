package classes;

import javax.persistence.*;
import java.sql.Time;


public class Location {
    private long nolocation;
    private long noexemplaire;
    private Time datedebut;
    private Time datefin;
    private Client clientByNosequence;

    public long getNolocation() {
        return nolocation;
    }

    public void setNolocation(long nolocation) {
        this.nolocation = nolocation;
    }

    public long getNoexemplaire() {
        return noexemplaire;
    }

    public void setNoexemplaire(long noexemplaire) {
        this.noexemplaire = noexemplaire;
    }

    public Time getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Time datedebut) {
        this.datedebut = datedebut;
    }

    public Time getDatefin() {
        return datefin;
    }

    public void setDatefin(Time datefin) {
        this.datefin = datefin;
    }


    public Client getClientByNosequence() {
        return clientByNosequence;
    }

    public void setClientByNosequence(Client clientByNosequence) {
        this.clientByNosequence = clientByNosequence;
    }
}
