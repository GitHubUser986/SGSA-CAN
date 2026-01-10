package models;

public class Staff extends UtilisateurCAN{

    public Staff ( String nom, String categorie){
        super( nom, "Staff");
    }

    @Override
    public int getNiveauAcces(){
        return 2;
    }
}
