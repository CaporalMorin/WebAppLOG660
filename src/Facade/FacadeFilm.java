package Facade;

import CourtierBD.CourtierBDFilm;
import classes.Film;

import java.util.List;

public class FacadeFilm {
    public FacadeFilm(){}

    public List<Film> chercherFilm(String criteres){
        CourtierBDFilm f = new CourtierBDFilm();
        return f.chercherFilm(criteres);
    }

    public Film consulterFilm(int noFilm){
        CourtierBDFilm f = new CourtierBDFilm();
        return f.consulterFilm(noFilm);
    }

}
