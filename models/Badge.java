package models;

import java.time.LocalDate;

import enums.Statut;
import interfaces.Accreditable;

public class Badge implements Accreditable{
    private int numeroBadge;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Statut statut;
    private UtilisateurCAN utilisateur;
    
    private static int compteur = 0;
    
    public Badge(UtilisateurCAN utilisateur, LocalDate dateDebut, LocalDate dateFin){
        LocalDate today = LocalDate.now();
        this.numeroBadge = ++compteur;
        this.utilisateur = utilisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        if(dateFin.isBefore(today)) {
            this.statut = Statut.EXPIRE;
        } else {
            this.statut = Statut.ACTIF;

        }
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
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