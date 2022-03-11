package webapp;

import Facade.FacadeFilm;
import classes.Film;
import classes.Paysfilm;
import classes.Personnagefilm;

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
import java.util.List;

@WebServlet("/consulterServlet")
public class ConsulterServlet extends HttpServlet {
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

        int noFilm = Integer.parseInt(requete.getParameter("noFilm"));

        try {
            FacadeFilm f = new FacadeFilm();
            Film film = f.consulterFilm(noFilm);
            creerPage(out, film);

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

    public void creerPage(PrintWriter out, Film film) {

        out.println("<h1>Film: " + film.getTitre() + "</h1>");
        out.println("<br>");
        out.println("<h2>Annee:" + film.getAnnee() + "</h2>");
        out.println("<h2>Duree:" + film.getDuree() + "</h2>");

        String paysString = "";
        Boolean first = true;
        for (Paysfilm p : film.getPaysfilmsByNofilm()) {
            if (first) {
                first = false;
            } else {
                paysString += "/";
            }
            paysString += p.getPays();
        }
        out.println("<h2>Pays:" + paysString + "</h2>");

        first = true;
        String acteurs = "";
        for (Personnagefilm perso : film.getPersonnagefilmsByNofilm()) {
            if (first) {
                first = false;
            } else {
                acteurs += "/";
            }
            acteurs += perso.getPersonneByNopersonne().getNom();
        }
        out.println("<h2>Acteurs:" + acteurs + "</h2>");
    }
}