package classes;

import java.sql.Time;


public class Cartecredit {
    private String nocartecredit;
    private String letype;
    private Time dateexpiration;
    private long cvv;
    private Time actualDate;
    private Client clientByNosequence;

    public Cartecredit(){

    }
    public Cartecredit(String noCarteCredit, Time dateActual, String type, Time  dateExpiration, int cvv){
        this.letype = type;
        this.nocartecredit = noCarteCredit;
        this.dateexpiration = dateExpiration;
        this.cvv = cvv;
        this.actualDate = dateActual;
    }

    public String getNocartecredit() {
        return nocartecredit;
    }

    public void setNocartecredit(String nocartecredit) {
        this.nocartecredit = nocartecredit;
    }

    public String getLetype() {
        return letype;
    }

    public void setLetype(String letype) {
        this.letype = letype;
    }

    public Time getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Time dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }

    public Time getActualDate() {
        return actualDate;
    }

    public void setActualDate(Time actualDate) {
        this.actualDate = actualDate;
    }


    public Client getClientByNosequence() {
        return clientByNosequence;
    }

    public void setClientByNosequence(Client clientByNosequence) {
        this.clientByNosequence = clientByNosequence;
    }
}
