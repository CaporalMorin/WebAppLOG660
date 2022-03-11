package CourtierBD;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import java.util.Map;

public class CourtierBDUtilisateur {

    public boolean connexion(String leCourriel, String leMotDePasse){

		if(leCourriel.isEmpty() || leMotDePasse.isEmpty()){
			System.out.println("Veuillez entrer une adresse courriel valide.");
			if(leMotDePasse.isEmpty()){
				System.out.println("Veuillez entrer un mot de passe valide.");
			}
			return false;
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
		}
		else{
			for(Object o: results){
				Map user = (Map)o;
				System.out.print("noSequence:" + user.get("NOSEQUENCE"));
				System.out.print(", prenom:" + user.get("PRENOM"));
				System.out.print(", nom:" + user.get("NOM"));
			}
			System.out.println("Connexion OK");
			return true;
		}
		return false;
	}
}
