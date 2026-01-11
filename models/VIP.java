package models;

import enums.CategorieVIP;

public class VIP extends UtilisateurCAN{
    
    public VIP( String nom, CategorieVIP categorie){
        super(nom, categorie.name());
    }

    @Override
    public int getNiveauAcces(){
        return 3;
    }
}
