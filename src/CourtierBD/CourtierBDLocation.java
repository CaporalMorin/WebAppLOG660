package CourtierBD;

import org.hibernate.Session;

import java.util.List;
public class CourtierBDLocation {
    private Session session;

    public CourtierBDLocation(){}

    public CourtierBDLocation(Session session){
        this.session = session;
    }

    public boolean locationFilm(int leNoFilm, String leCourriel){
		
		session.beginTransaction(); 
		
        int nbLocationFait = session.createQuery("select count(*) from location, client, utilisateur" + 
        "where location.noSequence = client.noSequence and client.noSequence = utilisateur.noSequence and utilisateur.courriel = :leCourriel").getFetchSize();
		
        int nbExemplaire = session.createQuery("select count(*) from exemplaire, film where film.noFilm = exemplaire.noFilm and exemplaire.noFilm = :leNoFilm" ).executeUpdate();
		
		int locationMax = session.createQuery("select locationMax from Forfait, utilisateur, client " + 
        "where forfait.code = client.code and client.noSequence = utilisateur.noSequence and utilisateur.courriel = :leCourriel").executeUpdate();
       
        if(nbExemplaire <= 0){
			System.out.println("Nombre d'exemplaire disponible est 0");    
        }
		else if(nbLocationFait >= locationMax){
			System.out.println("Nombre de location max atteint");
		
		}
	
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
