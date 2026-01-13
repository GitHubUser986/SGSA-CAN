package models;

import enums.Categorie;
import enums.CategorieStaff;

public class Staff extends UtilisateurCAN{
    private CategorieStaff categorieStaff;

    public Staff ( String nom, CategorieStaff categorieStaff){
        super( nom, Categorie.Staff);
        this.categorieStaff = categorieStaff;
    }

    @Override
    public int getNiveauAcces(){
        return 2;
    }

    public void setCategorieStaff(CategorieStaff categorieStaff){
        this.categorieStaff = categorieStaff;
    }

    public CategorieStaff getCategorieStaff() {
        return categorieStaff;
    }
}
