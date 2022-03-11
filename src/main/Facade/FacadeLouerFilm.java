package main.Facade;

import util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import main.classes.*;
import java.util.*;
import main.CourtierBD.*;

public class FacadeLouerFilm {
    private Session session;

    public FacadeLouerFilm() throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();

        }catch(HibernateException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List rechercherFilms(String titre, String realisateur, ArrayList<Personne> acteurs, String pays, String langue, String genre ){
        CourtierBDFilm courtierBDFilm = new CourtierBDFilm(session);

        return courtierBDFilm.chercherFilm(titre, realisateur, acteurs, pays, langue, genre);

    }
    
    public void closeSession(){
		if(session.isOpen())
			session.close();
	}
}
