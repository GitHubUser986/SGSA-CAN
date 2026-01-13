package models;

import enums.Categorie;
import enums.CategorieVIP;

public class VIP extends UtilisateurCAN{
    private CategorieVIP categorieVIP;
    
    public VIP( String nom, CategorieVIP categorieVIP){
        super(nom, Categorie.VIP);
        this.categorieVIP = categorieVIP;
    }

    @Override
    public int getNiveauAcces(){
        return 3;
    }

    public CategorieVIP getCategorieVIP() {
        return categorieVIP;
    }

    public void setCategorieVIP(CategorieVIP categorieVIP){
        this.categorieVIP = categorieVIP;
    }
}
