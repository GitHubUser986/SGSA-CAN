package models;

import java.time.LocalDate;

import interfaces.Accreditable;

public class Badge implements Accreditable{
    private int numeroBadge;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private boolean statut;
    private UtilisateurCAN utilisateur;

    private static int compteur = 0;

    public Badge(UtilisateurCAN utilisateur, LocalDate dateDebut, LocalDate dateFin){
        this.numeroBadge = ++compteur;
        this.utilisateur = utilisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = true;
    }

    @Override
    public void genererBadge(UtilisateurCAN utilisateur, LocalDate dateDebut, LocalDate dateFin){

    }

    @Override
    public void invaliderBadge(){

    }

    @Override 
    public boolean estBadgeValide(){
        return true;
    }


    
    public int getNumeroBadge() {
        return numeroBadge;
    }

    public void setNumeroBadge(int numeroBadge) {
        this.numeroBadge = numeroBadge;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public UtilisateurCAN getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurCAN utilisateur) {
        this.utilisateur = utilisateur;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Badge.compteur = compteur;
    }


    
    
}

// Badge : numeroBadge, utilisateur, dateDebut, dateFin, statut. 