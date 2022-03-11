package Facade;

import CourtierBD.CourtierBDUtilisateur;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

public class FacadeConnexion {
    private Session session;

    public FacadeConnexion() throws Exception{
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            closeSession();

        }catch(HibernateException e){
            e.printStackTrace();
            System.exit(1);
            System.out.println("Error facade connexion");

        }finally {
          closeSession();
        }
    }

    public Boolean connexion(String courriel, String mdp){
    	
        CourtierBDUtilisateur u = new CourtierBDUtilisateur();

        return u.connexion(courriel, mdp);
    }
    
    public void closeSession(){
		if(session.isOpen())
			session.close();
	}
}
