package CourtierBD;

import classes.Exemplaire;
import classes.Film;
import classes.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static util.utils.readStringFromMap;

public class CourtierBDLocation {

    public CourtierBDLocation(){}


    public boolean locationFilm(int noFilm, String leCourriel){
		System.out.println("Test3");
    	//String courriel = u.getCourriel();

		System.out.println("Obtention exemplaire de " + noFilm + "...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Test 4");


        int nbLocationFait = getNbLocation(leCourriel);
		System.out.println("nb: " + nbLocationFait);

		int nbExemplaire = getNbExemplaire(noFilm);
		System.out.println("nbExemplaire: " + nbExemplaire);


		int locationMax = getlocMax(leCourriel);
		System.out.println("loc max: " + locationMax);


        if(nbExemplaire <= 0){
			System.out.println("Nombre d'exemplaire disponible est 0");    
        }
		else if(nbLocationFait >= locationMax){
			System.out.println("Nombre de location max atteint");
		
		}
	
		else{
			int noClient = getidUser(leCourriel);
			System.out.println("Le num: "  + noClient);
			int noExemplaire = getIdExemplaire(noFilm);
			System.out.println("noEx: " + noExemplaire);
            int dureeMax = getidDuree(leCourriel);
			System.out.println("dur: " + dureeMax);
			LocalDate d = LocalDate.now();
			Date dateDebut = Date.valueOf(d);
			System.out.println("Date: " + dateDebut);
			LocalDate dateAdded = d.plusDays((long) dureeMax);
			Date dateFin = Date.valueOf(dateAdded);
			System.out.println(dateFin);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

			//a verifier
			String queryS ="INSERT INTO Location(NOEXEMPLAIRE, NOSEQUENCE, DATEDEBUT, DATEFIN) VALUES (noExemplaire, noSequence, dateDebut, dateFin)"
					.replace("noExemplaire",String.valueOf(noExemplaire))
					.replace("noSequence",String.valueOf(noClient)
					.replace("dateDebut", dateFormat.format(dateDebut))
					.replace("dateFin", dateFormat.format(dateFin)));
			Query query = session.createSQLQuery(queryS);

			//List insertion = session.createQuery("insert into location (noExemplaire, noSequence, dateDebut, dateFin) values (noExemplaire, noClient, CURDATE(), CURDATE() + dureeMax)").list();
			return true;
		}
		session.getTransaction().commit();
		return false;
	}

	private int getIdExemplaire(int noFilm){
		int nb = 0;

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT MIN(noExemplaire) as NBM FROM Exemplaire WHERE Exemplaire.noFilm = leNoFilm".replace("leNoFilm",String.valueOf(noFilm)) ;
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);

		System.out.println("2.8");

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List results = query.list();

		System.out.println("3");

		if(results.isEmpty()){
			System.out.println("Erreur: Film introuvable " + noFilm);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "NBM").toString());
			}
		}
		session.close();
		return nb;
	}

	private int getidDuree(String leCourriel){
		int nb = 0;


		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT dureeMax FROM Forfait ,Client, Utilisateur WHERE Forfait.code = Client.code and Client.noSequence = Utilisateur.noSequence and Utilisateur.courriel = 'leCourriel'".replace("leCourriel",leCourriel);
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		List results = query.list();




		if(results.isEmpty()){
			System.out.println("Erreur: courriel introuvable " + leCourriel);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "DUREEMAX").toString());
			}
		}
		session.close();
		return nb;
	}

	private int getidUser(String leCourriel){
		int nb = 0;


		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT nosequence FROM Utilisateur WHERE courriel = 'leCourriel'".replace("leCourriel",leCourriel);
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		List results = query.list();




		if(results.isEmpty()){
			System.out.println("Erreur: courriel introuvable " + leCourriel);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "NOSEQUENCE").toString());
			}
		}
		session.close();
		return nb;
	}

	private int getNbLocation(String leCourriel){
		int nb = 0;
		System.out.println("1");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("2");
		String queryString = "SELECT count(*) as MAXNB from Location, Client, Utilisateur \n" +
				"WHERE Location.noSequence = client.noSequence and client.noSequence = Utilisateur.noSequence and Utilisateur.courriel =  'leCourriel'".replace("leCourriel",leCourriel);
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);
		System.out.println("2.5");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		System.out.println("2.8");
		List results = query.list();


		System.out.println("3");

		if(results.isEmpty()){
			System.out.println("Erreur: courriel introuvable " + leCourriel);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "MAXNB").toString());
			}
		}
		session.close();
		return nb;
	}

	private int getNbExemplaire(int noFilm){
		int nb = 0;

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT count(*) as MAXNB FROM Exemplaire, Film WHERE Film.noFilm = Exemplaire.noFilm AND Exemplaire.noFilm = leNoFilm".replace("leNoFilm",String.valueOf(noFilm)) ;
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List results = query.list();



		if(results.isEmpty()){
			System.out.println("Erreur: Film introuvable " + noFilm);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "MAXNB").toString());
			}
		}
		session.close();
		return nb;
	}


	private int getlocMax(String leCourriel){
		int nb = 0;

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT locationmax FROM Forfait, Utilisateur, Client " +
				"WHERE Forfait.code = Client.code and Client.nosequence = Utilisateur.nosequence and Utilisateur.courriel = 'leCourriel'".replace("leCourriel",leCourriel) ;
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);

		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		List results = query.list();



		if(results.isEmpty()){
			System.out.println("Erreur: Courriel introuvable " + leCourriel);
			return nb;
		}
		else{
			for(Object o: results){
				Map loc = (Map)o;
				//session.close();
				nb = Integer.parseInt(readStringFromMap(loc, "LOCATIONMAX").toString());
			}
		}
		session.close();
		return nb;
	}
}
