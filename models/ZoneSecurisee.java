package models;

import interfaces.Securisable;

public class ZoneSecurisee implements Securisable{
    private int idZone;
    private String nomZone;
    private int niveauRequis;

    private static int compteur = 0;

    //*********sould we add an array for the authorized users!! 

    public ZoneSecurisee(int idZone, String nomZone, int niveauRequis){
        this.idZone = ++compteur;
        this.nomZone = nomZone;
        this.niveauRequis = niveauRequis;
    }

    @Override
    public void autoriser(ZoneSecurisee zone, UtilisateurCAN utilisateur) {
    }

    @Override
    public void refuser(ZoneSecurisee zone, UtilisateurCAN utilisateur) {
    }

    @Override
    public boolean verifierAcces(ZoneSecurisee zone, UtilisateurCAN utilisateur) {
        return true;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public String getNomZone() {
        return nomZone;
    }

    public void setNomZone(String nomZone) {
        this.nomZone = nomZone;
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        ZoneSecurisee.compteur = compteur;
    }


    
}
