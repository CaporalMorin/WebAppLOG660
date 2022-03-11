package main.classes;

import javax.persistence.*;

public class Adresse {
    private long noadresse;
    private String adresse;
    private String ville;
    private String province;
    private String codepostal;
    private Client clientByNosequence;

    public Adresse(){}

    public Adresse( String ville, int noAdresse, String adresse,  String province, String codePostal){
        this.adresse = adresse;
        this.province = province;
        this.codepostal = codePostal;
        this.noadresse = noAdresse;
        this.ville = ville;
    }

    public long getNoadresse() {
        return noadresse;
    }

    public void setNoadresse(long noadresse) {
        this.noadresse = noadresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public Client getClientByNosequence() {
        return clientByNosequence;
    }

    public void setClientByNosequence(Client clientByNosequence) {
        this.clientByNosequence = clientByNosequence;
    }
}
