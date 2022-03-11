package classes;

import java.sql.Time;
import java.util.Collection;
import java.util.Set;

public class Client extends Utilisateur{
    private int nosequence;
    private Cartecredit cartecreditsByNosequence;
    private Forfait forfaitByCode;
    private Set locationsByNosequence;

    public Client(){

    }
    public Client(int noSequence, String nom, String prenom, String courriel, String noTelephone, String motDePasse, Time dateNaissance, Adresse adresse,
                  Cartecredit cc, Set loc, Time actualDate){
        super(noSequence, nom, prenom, courriel, noTelephone,motDePasse,dateNaissance, adresse, actualDate);
        this.cartecreditsByNosequence = cc;
        this.locationsByNosequence = loc;

    }

    public int getNosequence() {
        return nosequence;
    }

    public void setNosequence(int nosequence) {
        this.nosequence = nosequence;
    }

    public Cartecredit getCartecreditsByNosequence() {
        return cartecreditsByNosequence;
    }

    public void setCartecreditsByNosequence(Cartecredit cartecreditsByNosequence) {
        this.cartecreditsByNosequence = cartecreditsByNosequence;
    }


    public Forfait getForfaitByCode() {
        return forfaitByCode;
    }

    public void setForfaitByCode(Forfait forfaitByCode) {
        this.forfaitByCode = forfaitByCode;
    }

    public Collection<Location> getLocationsByNosequence() {
        return locationsByNosequence;
    }

    public void setLocationsByNosequence(Set locationsByNosequence) {
        this.locationsByNosequence = locationsByNosequence;
    }
}
