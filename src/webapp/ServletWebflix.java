package webapp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.*;

import Facade.FacadeConnexion;
import oracle.jdbc.pool.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/webflix")
public class ServletWebflix extends HttpServlet {
    // Initialisation du parent
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    // Methode doGet: on utilise l’implementation de doPost
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // Traitement de la requete:
    // On recoit une chaine de charactere et on retourne un page HTML
    // contenant le titre des films de la BD contenant cette chaine
    // dans leur titre.
    public void doPost(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException, IOException {
        // Specifier le type et l’encodage des donnees
        reponse.setContentType("text/html");

        // Creer un PrintWriter pour imprimer la page Web de la reponse
        OutputStreamWriter osw = new OutputStreamWriter(reponse.getOutputStream());
        PrintWriter out = new PrintWriter(osw);

        try {
            connexion(out, requete);
        } catch (Exception e) {
            // Debug: afficher la trace d’erreur directement dans la page
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println("<p>" + sw.toString() + "</p>");
        } finally {
            try {
                // Liberer les connections et resources
                out.println("</body></html>");
                out.close();
            } catch (Exception lException) {
                lException.printStackTrace();
            }
        }
    }

    public void connexion(PrintWriter out, HttpServletRequest requete) throws Exception {
        // Recuperer le parametre provenant de la page HTML d’entree
        String courriel = requete.getParameter("courriel");
        String mdp = requete.getParameter("motpasse");
        if (courriel != null && mdp != null) {
            FacadeConnexion f = new FacadeConnexion();
            try{
                f.connexion(courriel, mdp);
                creerPage(out);
            }catch (Exception e){
                pageErreur(out, e);
            }
        }
    }

    public void creerPage(PrintWriter out) {
        out.println("<form action=\"rechercheServlet\" method=\"get\">");

        out.println("Saisir le titre du film: <input type=\"text\" name=\"titre\" size=\"20\">");
        out.println("<br>");

        out.println("<label>Choisir l'intervalle d'annee de sortie du film:</label>");
        out.println("<br>");
        out.println("<select name=\"anneeMin\">");
        for (int i = 1941; i <= 2022; i++) {
            out.println("<option value=\"" + i + "\">" + i + "</option>");
        }
        out.println("</select>");
        out.println("<select name=\"anneeMax\">");
        for (int i = 2022; i >= 1941; i--) {
            out.println("<option value=\"" + i + "\">" + i + "</option>");
        }
        out.println("</select>");
        out.println("Saisir le nom du pays de production: <input type=\"text\" name=\"pays\" size=\"20\">");
        out.println("<br>");
        out.println("Saisir la langue originale du film: <input type=\"text\" name=\"langue\" size=\"20\">");
        out.println("<br>");
        out.println("Saisir le nom du genre du film: <input type=\"text\" name=\"genre\" size=\"20\">");
        out.println("<br>");
        out.println("Saisir le nom du realisateur du film: <input type=\"text\" name=\"realisateur\" size=\"20\">");
        out.println("<br>");
        out.println("Saisir un acteur du film: <input type=\"text\" name=\"acteur\" size=\"20\">");
        out.println("<br>");


        out.println("<input type=\"submit\" value=\"Rechercher\" />");
        out.println("</form>");
    }

    public void pageErreur(PrintWriter out, Exception e){
        out.println("<h1>Erreur:" + e.toString() + "</h1>");
    }
}
