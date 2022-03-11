package test;

import Facade.FacadeConnexion;
import Facade.FacadeFilm;
import Facade.FacadeLouerFilm;

public class testLouerFilm {
    public static void main(String[] args) {
        String courriel = "DorothyLDiaz34@yahoo.com";
        int noFilm = 117913;

        try {
            System.out.println("Test1");
            FacadeLouerFilm f = new FacadeLouerFilm();
            f.louer(noFilm,courriel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
