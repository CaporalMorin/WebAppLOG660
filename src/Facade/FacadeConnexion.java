package Facade;

import CourtierBD.CourtierBDUtilisateur;
import classes.Utilisateur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

public class FacadeConnexion {
    private Session session;

    public FacadeConnexion(){}

    public Utilisateur connexion(String courriel, String mdp){
        CourtierBDUtilisateur u = new CourtierBDUtilisateur();
        return u.connexion(courriel, mdp);
    }
}
