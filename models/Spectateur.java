package models;

public class Spectateur extends UtilisateurCAN {

    public Spectateur(String nom, String categorie) {
        super( nom, "Spectateur");
    }

    @Override
    public int getNiveauAcces() {
        return 1;
    }
    
}
