package test;


import Facade.FacadeFilm;
import classes.Film;

import java.io.Serializable;

public class testConsultation implements Serializable{

	public static void main(String[] args) {
		int noFilm = 117913;

		try {
			FacadeFilm ff = new FacadeFilm();
			Film f = ff.consulterFilm(noFilm);
			System.out.println("Film:");
			System.out.println("noFilm: " + f.getNofilm());
			System.out.println(f.getScenaristefilmsByNofilm());
			System.out.println(f.getPaysfilmsByNofilm());
			System.out.println(f.getGenrefilmsByNofilm());
			System.out.println(f.getPersonnagefilmsByNofilm());

			System.out.println("Personnage: " + f.getPersonnagefilmsByNofilm().iterator().next().getNom() + " | Acteur: " + f.getPersonnagefilmsByNofilm().iterator().next().getPersonneByNopersonne().getNom());


		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}