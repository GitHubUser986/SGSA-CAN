package models;

import enums.CategorieStaff;

public class Staff extends UtilisateurCAN{

    public Staff ( String nom, CategorieStaff categorie){
        super( nom, categorie.name());
    }

    @Override
    public int getNiveauAcces(){
        return 2;
    }
}
