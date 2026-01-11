package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.ZoneInterditeException;

public class SecurityService{
    private ArrayList<UtilisateurCAN> utilisateurs;
    private ArrayList<Badge> Badges;
    private ArrayList<ZoneSecurisee> Zones;
    private ArrayList<AccesLog> accesLog;

    public SecurityService(){
        this.utilisateurs = new ArrayList<>();
        this.Badges = new ArrayList<>();
        this.Zones = new ArrayList<>();
        this.accesLog = new ArrayList<>();
    }

    /************************************* Users Managment *************************************/

    //L'ajout d'un utilisateur
    public void ajouterUtilisateur(UtilisateurCAN utilisateur) throws DonneeInvalideException{
        if (utilisateur == null){
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.utilisateurNull();
            throw exception;
        }

        if (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty()){
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.nomvide();
            throw exception;
        }
        utilisateurs.add(utilisateur);
        System.out.println("Utilisateur ajouté!");
    }

    //La recherche par nom
    public UtilisateurCAN rechercherParNom(String nom){
        if(nom == null || nom.trim().isEmpty()){
            return null;
        }
        String nomChercher = nom.toLowerCase();
        for (UtilisateurCAN utilisateur : utilisateurs){
            if(utilisateur.getNom().toLowerCase().contains(nomChercher)){
                System.out.println("utilisateur trouvé: \n");
                System.out.println(utilisateur);
                return utilisateur;
            }
        }
        System.out.println("L'utilisateur" + nom + " est introuvable");
        return null;
    }

    //La recherche par ID
    public UtilisateurCAN rechercherPadId(int id){
        for(UtilisateurCAN utilisateur : utilisateurs){
            if(utilisateur.getId() == id){
                System.out.println("utilisateur trouvé \n");
                System.out.println(utilisateur);
                return utilisateur;
            }
        }
        System.out.println("Utilisateur introuvable");
        return null;
    }

    //La liste des utilisateurs
    public void listerUtilisateurs(){
        if(utilisateurs.isEmpty()){
            System.out.println("Aucun utilisateur enregistré");
        }
        System.out.println("==========Liste Des Utilisateurs==========");
        for(UtilisateurCAN utilisateur : utilisateurs){
            System.out.println(utilisateur);
        }
    }

    //Le tri des utilisateur
    public void trierUtilisateurParNom(){
        Collections.sort(utilisateurs, new Comparator<UtilisateurCAN>() {
            @Override
            public int compare(UtilisateurCAN u1, UtilisateurCAN u2){
                return u1.getNom().compareToIgnoreCase(u2.getNom());
            }
        });
    }

    //Compter les utilisateurs par type
    public void compterUtilisateurParType(){
        int spectateur = 0;
        int staff = 0;
        int vip = 0;

        for (UtilisateurCAN utilisateur : utilisateurs){
            if (utilisateur instanceof Spectateur){
                spectateur++;
            }else if (utilisateur instanceof Staff){
                staff++;
            }else if (utilisateur instanceof VIP){
                vip++;
            }
        }

        System.out.println("Les Spectateur : " + spectateur);
        System.out.println("Les Staff : " + staff);
        System.out.println("Les VIP : " + vip);
    }


    /************************************* Zones Managment *************************************/

    // ajouter zone
    public void ajouterZone(ZoneSecurisee zone) throws DonneeInvalideException {

        if(zone.getNomZone().equals(null) || zone == null) {
            throw new DonneeInvalideException();
        }

        Zones.add(zone);
        System.out.println("Zone est ajoutée avec succès");

    }

    // rechercher zone par nom
    public ZoneSecurisee rechercherZone(String nom) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : Zones) {
            if(zoneSecurisee.getNomZone().equals(nom)) {
                return zoneSecurisee;
            }
        }
        throw new ZoneInterditeException();
        
    }

    // rechercher zone par id
    public ZoneSecurisee rechercherZoneParId(int idZone) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : Zones) {
            if(zoneSecurisee.getIdZone() == idZone) {
                return zoneSecurisee;
            }
        }
        throw new ZoneInterditeException();
    }

    // lister les zones
    public ArrayList<ZoneSecurisee> listerZones() throws DonneeInvalideException{
        if(Zones.size() == 0) {
            throw new DonneeInvalideException();
        }
        return Zones;
    }

    // trier la liste des zones par niveau
    public ArrayList<ZoneSecurisee> trierZonesParNiveau() throws DonneeInvalideException {
        if(Zones == null || Zones.isEmpty()) {
            throw new DonneeInvalideException();
        }
        ArrayList<ZoneSecurisee> zonesTriees = new ArrayList<>(Zones);
        zonesTriees.sort((zone1, zone2) -> Integer.compare(zone1.getNiveauRequis(), zone2.getNiveauRequis()));
        return zonesTriees;

    }

    // Générer un badge
    public Badge genererBadge(UtilisateurCAN user, LocalDate debut, LocalDate fin) throws DonneeInvalideException {
        if(debut == null || fin == null) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.dateInvalide();
            throw exception;
        }
        Badge badge = new Badge(user, debut, fin);
        return badge;
    }

    // Rechercher par numero de badge
    public Badge rechercherParBadge(int numeroBadge) throws BadgeInvalideException {
        for (Badge badge : Badges) {
            if(badge.getNumeroBadge() == numeroBadge) {
                return badge;
            }
        }
        BadgeInvalideException exception = new BadgeInvalideException();
        exception.badgeInexistent();
        throw exception;

    }

    // invalider un badge
    public void invaliderBadge(int numeroBadge) throws BadgeInvalideException{
        Badge badge;
        LocalDate dateFinBadge;
        badge = rechercherParBadge(numeroBadge);
        

    }
}