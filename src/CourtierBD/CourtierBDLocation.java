package CourtierBD;

import classes.Exemplaire;
import classes.Utilisateur;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;
public class CourtierBDLocation {

    public CourtierBDLocation(){}


    public boolean locationFilm(int noFilm, String leCourriel){
		System.out.println("Test3");
    	//String courriel = u.getCourriel();

		System.out.println("Obtention exemplaire de " + noFilm + "...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Test 4");


		//--------------------------------------------

		
       /* int nbLocationFait = session.createQuery("select count(*) from location, client, utilisateur" +
        "where location.noSequence = client.noSequence and client.noSequence = utilisateur.noSequence and utilisateur.courriel = leCourriel".replace("leCourriel",leCourriel)).getFetchSize();
		System.out.println("nb: " + nbLocationFait);*/

        int nbExemplaire = session.createQuery("select count(*) from exemplaire, film where film.noFilm = exemplaire.noFilm and exemplaire.noFilm = leNoFilm".replace("leNoFilm",String.valueOf(noFilm)) ).executeUpdate();
		System.out.println("nbExemplaire: " + nbExemplaire);
		int locationMax = session.createQuery("select locationMax from Forfait, utilisateur, client " + 
        "where forfait.code = client.code and client.noSequence = utilisateur.noSequence and utilisateur.courriel = leCourriel".replace("leCourriel",leCourriel)).executeUpdate();
       
        if(nbExemplaire <= 0){
			System.out.println("Nombre d'exemplaire disponible est 0");    
        }
		/*else if(nbLocationFait >= locationMax){
			System.out.println("Nombre de location max atteint");
		
		}*/
	
		else{
			int noClient = session.createQuery("select noSequence from client where courriel = :leCourriel").executeUpdate();
			int noExemplaire = session.createQuery("select noExemplaire from exemplaire limit 1").executeUpdate();
            int dureeMax = session.createQuery("select dureeMax from Forfait, utilisateur, client " + 
            "where forfait.code = client.code and client.noSequence = utilisateur.noSequence and utilisateur.courriel = :leCourriel").executeUpdate();

            //a verifier
			List insertion = session.createQuery("insert into location (noExemplaire, noSequence, dateDebut, dateFin) values (noExemplaire, noClient, CURDATE(), CURDATE() + dureeMax)").list();            return true;
		}		 
		session.getTransaction().commit();
		return false;
	}


}
