package Facade;

import util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import classes.*;
import java.util.*;
import CourtierBD.*;

public class FacadeLouerFilm {

    public List rechercherFilms(String criteres){
        CourtierBDFilm courtierBDFilm = new CourtierBDFilm();
        return courtierBDFilm.chercherFilm(criteres);
    }

    public Boolean louer(int noFilm, String c){
        System.out.println("Test2");
        CourtierBDLocation l = new CourtierBDLocation();
        return l.locationFilm(noFilm, c);
    }

}
