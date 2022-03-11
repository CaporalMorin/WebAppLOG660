package main.test;
import java.io.Serializable;

import Facade.FacadeConnexion;

public class testConnexion implements Serializable{

	public static void main(String[] args) {
		String courriel = "DorothyLDiaz34@yahoo.com";
		String mdp = "gaibei3I";

		try {
			FacadeConnexion f = new FacadeConnexion();
			f.connexion(courriel, mdp);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}