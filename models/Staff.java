package models;

import enums.Categorie;
import enums.CategorieStaff;

public class Staff extends UtilisateurCAN{

    public Staff ( String nom, CategorieStaff categorie){
        super( nom, Categorie.Staff);
    }

    @Override
    public int getNiveauAcces(){
        return 2;
    }
}
