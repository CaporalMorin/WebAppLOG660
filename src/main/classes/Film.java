package main.classes;

import java.util.Collection;
import java.util.Set;

public class Film {
    private long nofilm;
    private String titre;
    private long annee;
    private String langueoriginale;
    private int duree;
    private String resume;
    private String affiche;
    private Long nopersonne;
    private Set annoncefilmsByNofilm;
    private Set genrefilmsByNofilm;
    private Set paysfilmsByNofilm;
    private Set personnagefilmsByNofilm;
    private Set scenaristefilmsByNofilm;

    public Film(){}
    public Film(int noFilm, String titre, int annee, String langueOriginale, int duree, String resume, String affiche,
                Set annonces, Set genresFilm, Set paysFilm, Set scenaristeFilm){
        this.nofilm = noFilm;
        this.titre = titre;
        this.annee = annee;
        this.langueoriginale = langueOriginale;
        this.duree = duree;
        this.resume = resume;
        this.affiche = affiche;
        this.annoncefilmsByNofilm = annonces;
        this.genrefilmsByNofilm = genresFilm;
        this.paysfilmsByNofilm = paysFilm;
        this.scenaristefilmsByNofilm = scenaristeFilm;

    }

    public long getNofilm() {
        return nofilm;
    }

    public void setNofilm(long nofilm) {
        this.nofilm = nofilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public long getAnnee() {
        return annee;
    }

    public void setAnnee(long annee) {
        this.annee = annee;
    }

    public String getLangueoriginale() {
        return langueoriginale;
    }

    public void setLangueoriginale(String langueoriginale) {
        this.langueoriginale = langueoriginale;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }


    public Long getNopersonne() {
        return nopersonne;
    }

    public void setNopersonne(Long nopersonne) {
        this.nopersonne = nopersonne;
    }


    public Collection<Annoncefilm> getAnnoncefilmsByNofilm() {
        return annoncefilmsByNofilm;
    }

    public void setAnnoncefilmsByNofilm(Set annoncefilmsByNofilm) {
        this.annoncefilmsByNofilm = annoncefilmsByNofilm;
    }

    public Collection<Genrefilm> getGenrefilmsByNofilm() {
        return genrefilmsByNofilm;
    }

    public void setGenrefilmsByNofilm(Set genrefilmsByNofilm) {
        this.genrefilmsByNofilm = genrefilmsByNofilm;
    }

    public Collection<Paysfilm> getPaysfilmsByNofilm() {
        return paysfilmsByNofilm;
    }

    public void setPaysfilmsByNofilm(Set paysfilmsByNofilm) {
        this.paysfilmsByNofilm = paysfilmsByNofilm;
    }

    public Collection<Personnagefilm> getPersonnagefilmsByNofilm() {
        return personnagefilmsByNofilm;
    }

    public void setPersonnagefilmsByNofilm(Set personnagefilmsByNofilm) {
        this.personnagefilmsByNofilm = personnagefilmsByNofilm;
    }

    public Collection<Scenaristefilm> getScenaristefilmsByNofilm() {
        return scenaristefilmsByNofilm;
    }

    public void setScenaristefilmsByNofilm(Set scenaristefilmsByNofilm) {
        this.scenaristefilmsByNofilm = scenaristefilmsByNofilm;
    }
}
