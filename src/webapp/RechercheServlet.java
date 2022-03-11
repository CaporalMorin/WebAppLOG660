package webapp;

import CourtierBD.CourtierBDFilm;
import Facade.FacadeFilm;
import classes.Film;
import classes.Paysfilm;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rechercheServlet")
public class RechercheServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        // Specifier le type et l’encodage des donnees
        reponse.setContentType("text/html");

        // Creer un PrintWriter pour imprimer la page Web de la reponse
        OutputStreamWriter osw = new OutputStreamWriter(reponse.getOutputStream());
        PrintWriter out = new PrintWriter(osw);

        String titre = requete.getParameter("titre");
        String anneeDebut = requete.getParameter("anneeMin");
        String anneeFin = requete.getParameter("anneeMax");
        String pays = requete.getParameter("pays");
        String langue = requete.getParameter("langue");
        String acteur = requete.getParameter("acteur");
        String genre = requete.getParameter("genre");
        String realisateur = requete.getParameter("realisateur");

        try {
            Boolean first = true;
            String conditions = "";

            if(!titre.isEmpty() && titre != null){
                if(first){
                    first = false;
                }
                else{
                    conditions += " AND ";
                }
                conditions += "TITRE = '" + titre + "'";
            }
            if(!anneeDebut.isEmpty() && anneeDebut != null && !anneeFin.isEmpty() && anneeFin != null ){
                if(first){
                    first = false;
                }
                else{
                    conditions += " AND ";
                }
                conditions += "ANNEE BETWEEN " + anneeDebut + " AND " + anneeFin;
            }

            if(!pays.isEmpty() && pays != null){
                if(first){
                    first = false;
                }
                else{
                    conditions += " AND ";
                }
                conditions += "PAYS = '" + pays + "'";
            }

            if(!langue.isEmpty() && langue != null){
                if(first){
                    first = false;
                }
                else{
                    conditions += " AND ";
                }
                conditions += "LANGUEORIGINALE = '" + langue + "'";
            }

            if(!acteur.isEmpty() && acteur != null){
                if(first){
                    first = false;
                }else{
                    conditions += " AND ";
                }
                conditions += "NOM = '" + acteur + "'";
            }

            if(!genre.isEmpty() && genre != null){
                if(first){
                    first = false;
                }else{
                    conditions += " AND ";
                }
                conditions += "GENRE = '" + genre + "'";
            }

            if(!realisateur.isEmpty() && realisateur != null){
                if(first){
                    first = false;
                }else{
                    conditions += " AND ";
                }
                conditions += "NOM = '" + realisateur + "'";
            }

            FacadeFilm f = new FacadeFilm();
            List<Film> listFilm = f.chercherFilm(conditions);
            creerPage(out, listFilm);

        } catch (Exception e) {
            // Debug: afficher la trace d’erreur directement dans la page
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println("<p>" + sw.toString() + "</p>");
        } finally {
            try {
                // Liberer les connections et resources
                out.close();
            } catch (Exception lException) {
                lException.printStackTrace();
            }
        }
    }

    public void creerPage(PrintWriter out, List<Film> films) {

        out.println("<h1>Resultats de la recherche</h1>");
        out.println("<br>");

        if(films.size() > 0){
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>noFilm</th>");
            out.println("<th>Titre</th>");
            out.println("<th>Annee</th>");
            out.println("<th>Langue</th>");
            out.println("<th>Pays</th>");
            out.println("<th>Duree(mins)</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");
            for(Film f : films){
                out.println("<tr>");
                out.println("<td>" + f.getNofilm() +"</td>");
                out.println("<td>" + f.getTitre() +"</td>");
                out.println("<td>" + f.getAnnee() +"</td>");
                out.println("<td>" + f.getLangueoriginale() +"</td>");
                String paysString = "";
                Boolean first = true;
                for(Paysfilm p : f.getPaysfilmsByNofilm()){
                    if(first){
                        first = false;
                    }else{
                        paysString += "/";
                    }
                    paysString += p.getPays();
                }
                out.println("<td>" + paysString +"</td>");
                out.println("<td>" + f.getDuree() +"</td>");

                out.println("<td>");
                out.println("<button onclick=\"location.href='http://localhost:8080/WebAppLOG660/consulterServlet?noFilm=" + f.getNofilm()+ "'\">Consulter</button>");
                out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table>");
        }else{
            out.println("<h2>Aucun film trouvé avec ces critères.</h2>");
        }
    }

}


