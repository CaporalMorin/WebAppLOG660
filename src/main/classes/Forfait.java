package main.classes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


public class Forfait {
    private String type;
    private long cout;
    private long locationmax;
    private long dureemax;
    private String code;


    public Forfait(){}
    public Forfait( String type, int cout, int locationMax, int dureeMax, String code){
        this.type = type;
        this.cout = cout;
        this.locationmax = locationMax;
        this.dureemax = dureeMax;
        this.code = code;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCout() {
        return cout;
    }

    public void setCout(long cout) {
        this.cout = cout;
    }

    public long getLocationmax() {
        return locationmax;
    }

    public void setLocationmax(long locationmax) {
        this.locationmax = locationmax;
    }


    public long getDureemax() {
        return dureemax;
    }

    public void setDureemax(long dureemax) {
        this.dureemax = dureemax;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
