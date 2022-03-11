package CourtierBD;

import classes.Adresse;
import classes.Utilisateur;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import util.utils;

import java.util.List;
import java.util.Map;

import static util.utils.readStringFromMap;

public class CourtierBDUtilisateur {

	public Utilisateur connexion(String leCourriel, String leMotDePasse){

		if(leCourriel.isEmpty() || leMotDePasse.isEmpty()){
			System.out.println("Veuillez entrer une adresse courriel valide.");
			if(leMotDePasse.isEmpty()){
				System.out.println("Veuillez entrer un mot de passe valide.");
			}
			return null;
		}
		System.out.println("Tentative de connexion...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT * FROM Utilisateur WHERE courriel = 'lecourriel' AND motdepasse = 'lemdp'"
				.replace("lecourriel", leCourriel)
				.replace("lemdp", leMotDePasse);
		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List results = query.list();

		if(results.isEmpty()){
			System.out.println("Erreur: Courriel ou mot de passe invalide");
			return null;
		}
		else{
			for(Object o: results){
				Map user = (Map)o;
				session.close();
				return mapToUser(user);
			}
		}
		session.close();
		return null;
	}

	private Adresse getAdresse(int noSequence){
		Session session = HibernateUtil.getSessionFactory().openSession();

		String queryString = "SELECT * FROM Adresse WHERE nosequence = lenoseq"
				.replace("lenoseq", String.valueOf(noSequence));

		System.out.println(queryString);
		Query query = session.createSQLQuery(queryString);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List results = query.list();

		if(results.isEmpty()){
			System.out.println("Erreur: Numéro de sequence invalide.");
			return null;
		}
		else {
			for (Object o : results) {
				Map adresse = (Map) o;
				session.close();
				return mapToAdresse(adresse);
			}
		}
		session.close();
		return null;
	}

	private Adresse mapToAdresse(Map adresse){
		return new Adresse(
				readStringFromMap(adresse,"VILLE").toString(),
				Integer.parseInt(readStringFromMap(adresse,"NOADRESSE").toString()),
				readStringFromMap(adresse,"ADRESSE").toString(),
				readStringFromMap(adresse,"PROVINCE").toString(),
				readStringFromMap(adresse,"CODEPOSTAL").toString()
		);
	}

	private Utilisateur mapToUser(Map user){
		return new Utilisateur(
				Integer.parseInt(readStringFromMap(user,"NOSEQUENCE").toString()),
				readStringFromMap(user,"NOM").toString(),
				readStringFromMap(user,"PRENOM").toString(),
				readStringFromMap(user,"COURRIEL").toString(),
				readStringFromMap(user,"NOTELEPHONE").toString(),
				readStringFromMap(user,"MOTDEPASSE").toString(),
				utils.dateStringToTime(readStringFromMap(user,"DATENAISSANCE").toString()),
				getAdresse(Integer.parseInt(readStringFromMap(user,"NOSEQUENCE").toString())),
				utils.dateStringToTime(readStringFromMap(user,"ACTUAL_DATE").toString())
		);
	}
}
