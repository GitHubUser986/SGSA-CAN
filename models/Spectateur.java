package models;

import enums.Categorie;
import enums.CategorieSpectateur;

public class Spectateur extends UtilisateurCAN {
    private CategorieSpectateur categorieSpectateur;

    public Spectateur(String nom, CategorieSpectateur categorieSpectateur) {
        super( nom, Categorie.Spectateur);
        this.categorieSpectateur = categorieSpectateur;
    }

    @Override
    public int getNiveauAcces() {
        return 1;
    }

    public CategorieSpectateur getCategorieSpectateur(){
        return categorieSpectateur;
    }

    public void setCategorieSpectateur(CategorieSpectateur categorieSpectateur){
        this.categorieSpectateur = categorieSpectateur;
    }
    
}
