package main.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Exemplaire {
    private int noexemplaire;
    private int disponible;
    private int nofilm;

    public Exemplaire(){}
    public Exemplaire(int noExemplaire, int disponible) {
        this.disponible = disponible;
        this.noexemplaire = noExemplaire;

    }

    public int getNoexemplaire() {
        return noexemplaire;
    }

    public void setNoexemplaire(int noexemplaire) {
        this.noexemplaire = noexemplaire;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getNofilm() {
        return nofilm;
    }

    public void setNofilm(int nofilm) {
        this.nofilm = nofilm;
    }


}
