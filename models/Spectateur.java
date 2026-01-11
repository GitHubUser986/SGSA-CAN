package models;

import enums.CategorieSpectateur;

public class Spectateur extends UtilisateurCAN {

    public Spectateur(String nom, CategorieSpectateur categorie) {
        super( nom, categorie.name());
    }

    @Override
    public int getNiveauAcces() {
        return 1;
    }
    
}
