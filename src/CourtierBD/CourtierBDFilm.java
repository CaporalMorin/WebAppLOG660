package CourtierBD;

import classes.Film;
import classes.Personne;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
public class CourtierBDFilm{

    private Session session;

    public CourtierBDFilm(){}

    public CourtierBDFilm(Session session){
        this.session = session;
    }

    //a verifier
    public List<Film> chercherFilm(String titre, String realisateur, ArrayList<Personne> acteurs, String pays, String langue, String genre ){
        session.beginTransaction(); 
		
		String query = "FROM Film f WHERE ";

        if(!titre.isEmpty()){
            query += "LOWER(f.titre) like '%" + titre.toLowerCase() + "%' ";
        }

        if(!realisateur.isEmpty()){
            query += "LOWER(f.langue) like + '%" + langue.toLowerCase() + "%' ";
        }

        if(!pays.isEmpty()){
            query += "f.noFilm in (select pf.pays from PaysFilm pf where pf.nofilm = f.noFilm and lower(fp.pays) = ' " + pays.toLowerCase() + "')";
        }

        if(!genre.isEmpty()){
            query += "f.noFilm in (select g.genre from genreFilm g where g.nofilm = f.noFilm and lower(g.genre) = ' " + genre.toLowerCase() + "')";
        }

        if(!genre.isEmpty()){
            query += "f.noFilm in (select g.genre from genreFilm g where g.nofilm = f.noFilm and lower(g.genre) = ' " + genre.toLowerCase() + "')";
        }

        if(!(acteurs.size() == 0)){
            for(int i = 0; i <acteurs.size(); i++){
                query += "f.noPersonne in ( select p.noPersonne from personne p where f.noPersonne = p.noPersonne and lower(p.nom) like '%" + acteurs.get(i).getNom().toLowerCase() + "%' ";
            }

        }

        query += "order by f.titre";

        List films = session.createQuery(query).list();

        session.getTransaction().commit();
        
        return films;
    }

    
}
