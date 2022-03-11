package CourtierBD;

import classes.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.utils;

import java.util.*;

import static util.utils.readStringFromMap;

public class CourtierBDFilm{
    public CourtierBDFilm(){}

    //a verifier
    public List<Film> chercherFilm(String criteres){

        List<Film> films = new ArrayList<Film>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String sqlquery = "SELECT * FROM Film WHERE " + criteres;
        System.out.println(sqlquery);
        Query query = session.createSQLQuery(sqlquery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Aucun film trouvé selon les critères de recherche.");
            return null;
        }
        else{
            for(Object o: results){
                Map film = (Map)o;
                Film f = mapToFilm(film);
                films.add(f);
            }
        }
        session.close();
        return films;
    }

    public Film consulterFilm(int noFilm){
        System.out.println("Obtention du film " + noFilm + "...");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM Film WHERE nofilm = lenoseq".replace("lenoseq", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Film introuvable avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map film = (Map)o;
                session.close();
                return mapToFilm(film);
            }
        }
        session.close();
        return null;
    }

    private Film mapToFilm(Map film){
        int noFilm = Integer.parseInt(readStringFromMap(film, "NOFILM").toString());
        return new Film(
                noFilm,
                readStringFromMap(film,"TITRE").toString(),
                Integer.parseInt(readStringFromMap(film,"ANNEE").toString()),
                readStringFromMap(film,"LANGUEORIGINALE").toString(),
                Integer.parseInt(readStringFromMap(film,"DUREE").toString()),
                readStringFromMap(film,"RESUME").toString(),
                readStringFromMap(film,"AFFICHE").toString(),
                getAnnonces(noFilm),
                getGenresFilm(noFilm),
                getPaysFilm(noFilm),
                getScenaristesFilm(noFilm),
                getPersonnagesFilm(noFilm)
        );
    }


    private Set<Annoncefilm> getAnnonces(int noFilm){
        Set<Annoncefilm> annonces = new HashSet<Annoncefilm>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM AnnonceFilm WHERE nofilm = lenofilm".replace("lenofilm", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Annonces introuvables avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map annonce = (Map)o;
                annonces.add(new Annoncefilm(readStringFromMap(annonce, "LIEN").toString(), noFilm));
            }
        }
        session.close();
        return annonces;
    }

    private Set<Genrefilm> getGenresFilm(int noFilm){
        Set<Genrefilm> genres = new HashSet<Genrefilm>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM GenreFilm WHERE nofilm = lenofilm".replace("lenofilm", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Genres introuvables avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map genre = (Map)o;
                genres.add(new Genrefilm(readStringFromMap(genre,"GENRE").toString(), noFilm));
            }
        }
        session.close();
        return genres;
    }

    private Set<Paysfilm> getPaysFilm(int noFilm){
        Set<Paysfilm> pays = new HashSet<Paysfilm>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM PaysFilm WHERE nofilm = lenofilm".replace("lenofilm", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Pays introuvables avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map pays_map = (Map)o;
                pays.add(new Paysfilm(readStringFromMap(pays_map,"PAYS").toString(), noFilm));
            }
        }
        session.close();
        return pays;
    }

    private Set<Personnagefilm> getPersonnagesFilm(int noFilm){
        Set<Personnagefilm> personnages = new HashSet<Personnagefilm>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM PersonnageFilm WHERE nofilm = lenofilm".replace("lenofilm", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Personnages introuvables avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map personnagefilm = (Map)o;

                personnages.add(new Personnagefilm(
                        Integer.parseInt(readStringFromMap(personnagefilm, "NOPERSONNAGE").toString()),
                        readStringFromMap(personnagefilm,"NOM").toString(),
                        getPersonne(Integer.parseInt(readStringFromMap(personnagefilm,"NOPERSONNE").toString()))
                ));
            }
        }
        session.close();
        return personnages;
    }

    private Personne getPersonne(int noPersonne){
        Personne p = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM Personne WHERE noPersonne = lenopersonne".replace("lenopersonne", String.valueOf(noPersonne));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Personne introuvables avec le noPersonne " + noPersonne);
            return null;
        }
        else{
            for(Object o: results){
                Map personne = (Map)o;
                p = new Personne(
                        Integer.parseInt(readStringFromMap(personne, "NOPERSONNE").toString()),
                        readStringFromMap(personne,"NOM").toString(),
                        readStringFromMap(personne,"PHOTO").toString(),
                        readStringFromMap(personne,"BIOGRAPHIE").toString(),
                        utils.dateStringToTime(readStringFromMap(personne,"DATENAISSANCE").toString()),
                        readStringFromMap(personne,"LIEUNAISSANCE").toString()
                );
            }
        }
        session.close();
        return p;
    }

    private Set<Scenaristefilm> getScenaristesFilm(int noFilm){
        Set<Scenaristefilm> scenaristes = new HashSet<Scenaristefilm>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String queryString = "SELECT * FROM ScenaristeFilm WHERE nofilm = lenofilm".replace("lenofilm", String.valueOf(noFilm));
        System.out.println(queryString);
        Query query = session.createSQLQuery(queryString);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.list();

        if(results.isEmpty()){
            System.out.println("Erreur: Scenaristes introuvables avec le noFilm " + noFilm);
            return null;
        }
        else{
            for(Object o: results){
                Map scenariste = (Map)o;
                scenaristes.add(new Scenaristefilm(noFilm, readStringFromMap(scenariste, "NOM").toString()));
            }
        }
        session.close();
        return scenaristes;
    }

    
}
