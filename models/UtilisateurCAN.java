package models;

import enums.Categorie;

public abstract class UtilisateurCAN {
    protected int id;
    protected String nom;
    protected Categorie categorie;
    protected Badge badge;

    private static int compteur = 0;

    public UtilisateurCAN(String nom, Categorie categorie) {
        this.id = ++compteur;
        this.nom = nom;
        this.categorie = categorie;
    }


    @Override
    public String toString(){
        return "ID: " + id + "\n" +
               "Nom: "+ nom + "\n" +
               "Categorie: " + "\n" +
               "Niveau: " + getNiveauAcces() +
               "Badge: " + (badge != null ? badge.getNumeroBadge() : "Aucun") + "\n";
    }

    public abstract int getNiveauAcces();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        UtilisateurCAN.compteur = compteur;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    
}
