package models;

import java.util.ArrayList;

import exceptions.DonneeInvalideException;

public class SecurityService{
    private ArrayList<UtilisateurCAN> utilisateurs;
    private ArrayList<Badge> badges;
    private ArrayList<ZoneSecurisee> Zones;
    private ArrayList<AccesLog> accesLog;

    public SecurityService(){
        this.utilisateurs = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.Zones = new ArrayList<>();
        this.accesLog = new ArrayList<>();
    }

    public void ajouterUtilisateur(UtilisateurCAN utilisateur) throws DonneeInvalideException{
        if (utilisateur == null){
            throw new DonneeInvalideException();
        }

        if (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty()){
            throw new DonneeInvalideException();
        }
        utilisateurs.add(utilisateur);
        System.out.println("Utilisateur ajouté!");
    }
}