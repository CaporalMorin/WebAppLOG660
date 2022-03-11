package test;

import Facade.FacadeFilm;
import classes.Film;

import java.io.Serializable;
import java.util.List;

public class testRechercherFilm implements Serializable{

	public static void main(String[] args) {
		int noFilm = 117913;

		try {
			FacadeFilm ff = new FacadeFilm();
			List<Film> films = ff.chercherFilm("duree BETWEEN 60 AND 70");
			for(Film f : films){
				System.out.println(f.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}