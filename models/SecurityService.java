package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import exceptions.DonneeInvalideException;
import exceptions.ZoneInterditeException;

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

    public void ajouterZone(ZoneSecurisee zone) throws DonneeInvalideException {

        if(zone.getNomZone().equals(null) || zone == null) {
            throw new DonneeInvalideException();
        }

        Zones.add(zone);
        System.out.println("Zone est ajoutée avec succès");

    }

    public ZoneSecurisee rechercherZone(String nom) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : Zones) {
            if(zoneSecurisee.getNomZone().equals(nom)) {
                return zoneSecurisee;
            }
        }
        throw new ZoneInterditeException();
        
    }

    public ZoneSecurisee rechercherZoneParId(int idZone) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : Zones) {
            if(zoneSecurisee.getIdZone() == idZone) {
                return zoneSecurisee;
            }
        }
        throw new ZoneInterditeException();
    }

    public ArrayList<ZoneSecurisee> listerZones() throws DonneeInvalideException{
        if(Zones.size() == 0) {
            throw new DonneeInvalideException();
        }
        return Zones;
    }

    public ArrayList<ZoneSecurisee> trierZonesParNiveau() throws DonneeInvalideException {
        if(Zones == null || Zones.isEmpty()) {
            throw new DonneeInvalideException();
        }
        ArrayList<ZoneSecurisee> zonesTriees = new ArrayList<>(Zones);
        zonesTriees.sort((zone1, zone2) -> Integer.compare(zone1.getNiveauRequis(), zone2.getNiveauRequis()));
        return zonesTriees;

    }
}