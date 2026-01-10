package models;

public class VIP extends UtilisateurCAN{
    
    public VIP( String nom, String categorie){
        super(nom, "VIP");
    }

    @Override
    public int getNiveauAcces(){
        return 3;
    }
}
