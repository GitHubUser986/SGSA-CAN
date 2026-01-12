package models;

import enums.Categorie;
import enums.CategorieVIP;

public class VIP extends UtilisateurCAN{
    
    public VIP( String nom, CategorieVIP categorie){
        super(nom, Categorie.VIP);
    }

    @Override
    public int getNiveauAcces(){
        return 3;
    }
}
