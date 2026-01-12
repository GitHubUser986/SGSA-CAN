package models;

import enums.Categorie;
import enums.CategorieSpectateur;

public class Spectateur extends UtilisateurCAN {

    public Spectateur(String nom, CategorieSpectateur categorie) {
        super( nom, Categorie.Spectateur);
    }

    @Override
    public int getNiveauAcces() {
        return 1;
    }
    
}
