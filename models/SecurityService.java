package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import enums.Statut;
import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;

public class SecurityService {
    private ArrayList<UtilisateurCAN> utilisateurs;
    private ArrayList<Badge> badges;
    private ArrayList<ZoneSecurisee> zones;
    private ArrayList<AccesLog> accesLog;

    public SecurityService() {
        this.utilisateurs = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.zones = new ArrayList<>();
        this.accesLog = new ArrayList<>();
    }

    /*************************************
     * Users Management
     *************************************/

    // L'ajout d'un utilisateur
    public void ajouterUtilisateur(UtilisateurCAN utilisateur) throws DonneeInvalideException {
        if (utilisateur == null) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.utilisateurNull();
            throw exception;
        }

        if (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.nomvide();
            throw exception;
        }
        utilisateurs.add(utilisateur);
        System.out.println("Utilisateur ajouté!");
    }

    // La recherche par nom
    public UtilisateurCAN rechercherParNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            return null;
        }
        String nomChercher = nom.toLowerCase();
        for (UtilisateurCAN utilisateur : utilisateurs) {
            if (utilisateur.getNom().toLowerCase().contains(nomChercher)) {
                System.out.println("utilisateur trouvé: \n");
                System.out.println(utilisateur);
                return utilisateur;
            }
        }
        System.out.println("L'utilisateur" + nom + " est introuvable");
        return null;
    }

    // La recherche par ID
    public UtilisateurCAN rechercherPadId(int id) {
        for (UtilisateurCAN utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                System.out.println("utilisateur trouvé \n");
                System.out.println(utilisateur);
                return utilisateur;
            }
        }
        System.out.println("Utilisateur introuvable");
        return null;
    }

    // La liste des utilisateurs
    public void listerUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré");
        }
        System.out.println("==========Liste Des Utilisateurs==========");
        for (UtilisateurCAN utilisateur : utilisateurs) {
            System.out.println(utilisateur);
        }
    }

    // Le tri des utilisateur
    public void trierUtilisateurParNom() {
        Collections.sort(utilisateurs, new Comparator<UtilisateurCAN>() {
            @Override
            public int compare(UtilisateurCAN u1, UtilisateurCAN u2) {
                return u1.getNom().compareToIgnoreCase(u2.getNom());
            }
        });
    }

    // Compter les utilisateurs par type
    public void compterUtilisateurParType() {
        int spectateur = 0;
        int staff = 0;
        int vip = 0;

        for (UtilisateurCAN utilisateur : utilisateurs) {
            if (utilisateur instanceof Spectateur) {
                spectateur++;
            } else if (utilisateur instanceof Staff) {
                staff++;
            } else if (utilisateur instanceof VIP) {
                vip++;
            }
        }

        System.out.println("Les Spectateur : " + spectateur);
        System.out.println("Les Staff : " + staff);
        System.out.println("Les VIP : " + vip);
    }

    /*************************************
     * Zones Management
     *************************************/

    // ajouter zone
    public void ajouterZone(ZoneSecurisee zone) throws DonneeInvalideException {

        if (zone.getNomZone().trim().isEmpty() || zone == null) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.nomvide();
            throw exception;
        }

        zones.add(zone);
        System.out.println("Zone est ajoutée avec succès");

    }

    // rechercher zone par nom
    public ZoneSecurisee rechercherZone(String nom) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : zones) {
            if (zoneSecurisee.getNomZone().equals(nom)) {
                return zoneSecurisee;
            }
        }
        ZoneInterditeException exception = new ZoneInterditeException();
        exception.zoneInexistante();
        throw exception;

    }

    // rechercher zone par id
    public ZoneSecurisee rechercherZoneParId(int idZone) throws ZoneInterditeException {
        for (ZoneSecurisee zoneSecurisee : zones) {
            if (zoneSecurisee.getIdZone() == idZone) {
                return zoneSecurisee;
            }
        }
        ZoneInterditeException exception = new ZoneInterditeException();
        exception.zoneInexistante();
        throw exception;
    }

    // lister les zones
    public ArrayList<ZoneSecurisee> listerZones() throws DonneeInvalideException {
        if (zones.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }
        return zones;
    }

    // trier la liste des zones par niveau
    public ArrayList<ZoneSecurisee> trierZonesParNiveau() throws DonneeInvalideException {
        if (zones == null || zones.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }
        ArrayList<ZoneSecurisee> zonesTriees = new ArrayList<>(zones);
        zonesTriees.sort((zone1, zone2) -> Integer.compare(zone1.getNiveauRequis(), zone2.getNiveauRequis()));
        return zonesTriees;

    }

    /*************************************
     * Badges Management
     *************************************/

    // Générer un badge
    public Badge genererBadge(UtilisateurCAN user, LocalDate debut, LocalDate fin) throws DonneeInvalideException {
        if (debut == null || fin == null) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.dateInvalide();
            throw exception;
        }
        Badge badge = new Badge(user, debut, fin);
        badges.add(badge);
        return badge;
    }

    // Rechercher par numero de badge
    public Badge rechercherParBadge(int numeroBadge) throws BadgeInvalideException {
        for (Badge badge : badges) {
            if (badge.getNumeroBadge() == numeroBadge) {
                return badge;
            }
        }
        BadgeInvalideException exception = new BadgeInvalideException();
        exception.badgeInexistent();
        throw exception;

    }

    // invalider un badge
    public void invaliderBadge(int numeroBadge) throws BadgeInvalideException {
        Badge badge = rechercherParBadge(numeroBadge);
        LocalDate dateFinBadge = badge.getDateFin();
        LocalDate currentDate = LocalDate.now();

        if (dateFinBadge.isBefore(currentDate)) {
            badge.setStatut(Statut.EXPIRE);
        }

        if (badge.getStatut().equals(Statut.EXPIRE)) {
            BadgeInvalideException exception = new BadgeInvalideException();
            exception.badgeExpire();
            throw exception;
        }

    }

    // bloquer Badge
    public void bloquerBadge(int numeroBadge, UtilisateurCAN admin)
            throws UnauthorizedException, BadgeInvalideException {
        Badge badge;
        badge = rechercherParBadge(numeroBadge);

        if (!(admin instanceof Staff)) {
            UnauthorizedException exception = new UnauthorizedException();
            exception.staffOnly();
            throw exception;
        }

        if (badge.getStatut() == Statut.BLOQUE) {
            System.out.println("Cet utilisateur est déjà bloqué");
        } else {
            badge.setStatut(Statut.BLOQUE);
            System.out.println("Cet utilisateur est bloqué avec succès");
        }
    }

    // débloquer badge
    public void debloquerBadge(int numeroBadge, UtilisateurCAN admin)
            throws UnauthorizedException, BadgeInvalideException {
        Badge badge;
        badge = rechercherParBadge(numeroBadge);

        if (!(admin instanceof Staff)) {
            UnauthorizedException exception = new UnauthorizedException();
            exception.staffOnly();
            throw exception;
        }

        if (badge.getStatut() == Statut.BLOQUE) {
            badge.setStatut(Statut.ACTIF);
            System.out.println("Cet utilisateur est débloqué avec succès");
        } else {
            System.out.println("Cet utilisateur est déjà débloqué");
        }
    }

    // vérifier la validité de badge
    public void verifierValiditeBadge(Badge badge) throws BadgeInvalideException {
        if (badge == null) {
            BadgeInvalideException exception = new BadgeInvalideException();
            exception.badgeInexistent();
            throw exception;
        }

        LocalDate dateFin = badge.getDateFin();
        LocalDate currenDate = LocalDate.now();
        Statut statut = badge.getStatut();

        if (dateFin.isAfter(currenDate)) {
            if (statut == Statut.ACTIF) {
                System.out.println("Le badge est actif");
            } else if (statut == Statut.BLOQUE) {
                System.out.println("Le badge est bloqué");
            } else {
                System.out.println("Le badge est inactif");
            }
        } else {
            System.out.println("Le badge est expiré");
        }
    }

    // lister les badges actifs
    public ArrayList<Badge> listerBadgesActifs() throws DonneeInvalideException {
        if (badges.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }
        ArrayList<Badge> badgesActifs = new ArrayList<Badge>();

        for (Badge badge : badges) {
            if (badge.getStatut() == Statut.ACTIF) {
                badgesActifs.add(badge);
            }
        }

        if (badgesActifs.isEmpty()) {
            System.out.println("Aucun badge est actif");
        }

        return badgesActifs;
    }

    // lister les badges bloqués
    public ArrayList<Badge> listerBadgesBloques() throws DonneeInvalideException {
        if (badges.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }

        ArrayList<Badge> badgesBloques = new ArrayList<Badge>();

        for (Badge badge : badges) {
            if (badge.getStatut() == Statut.BLOQUE) {
                badgesBloques.add(badge);
            }
        }

        if (badgesBloques.isEmpty()) {
            System.out.println("Aucun badge est bloqué");
        }

        return badgesBloques;
    }

    // lister les badges expirés
    public ArrayList<Badge> listerBadgesExpires() throws DonneeInvalideException {
        if (badges.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }

        ArrayList<Badge> badgesExpires = new ArrayList<>();
        for (Badge badge : badges) {
            if (badge.getStatut() == Statut.EXPIRE) {
                badgesExpires.add(badge);
            }
        }

        if (badgesExpires.isEmpty()) {
            System.out.println("Aucun badge est expiré");
        }

        return badgesExpires;
    }

    /**************************************
     * Access Control
     *************************************/
    public boolean verfierAcces(int numeroBadge, String nomZone) throws BadgeInvalideException {
        Badge badge = rechercherParBadge(numeroBadge);

        if (!badge.estBadgeValide()) {
            String raison = "REFUS : Badge invalide, expiré ou bloqué";
            ZoneSecurisee zone = null;
            try {
                zone = rechercherZone(nomZone);
            } catch (ZoneInterditeException e) {
            }
            refuserAcces(badge, zone, raison);
            return false;
        }

        ZoneSecurisee zone = null;
        try {
            zone = rechercherZone(nomZone);
        } catch (ZoneInterditeException e) {
            refuserAcces(badge, zone, "Zone inexistante");
            return false;
        }

        UtilisateurCAN utilisateur = badge.getUtilisateur();

        if (utilisateur.getNiveauAcces() < zone.getNiveauRequis()) {
            String raison = "Niveau d'accès insuffisant (" + utilisateur.getNiveauAcces() + " < "
                    + zone.getNiveauRequis();
            refuserAcces(badge, zone, raison);
            return false;
        }

        autoriserAcces(badge, zone);
        return true;
    }

    public void autoriserAcces(Badge badge, ZoneSecurisee zone) {

        UtilisateurCAN utilisateur = badge.getUtilisateur();

        System.out.println("Accés Autorisé");
        System.out.println(" • Utilisateur : " + utilisateur.getNom() + " (ID: " + utilisateur.getId() + " )");
        System.out.println(" • Badge N° : " + badge.getNumeroBadge());
        System.out.println(" • Zone : " + zone.getNomZone());
        System.out.println(" • Niveau utilisateur : " + utilisateur.getNiveauAcces());
        System.out.println(" • Niveau requis : " + zone.getNiveauRequis());

        String raison = "";

        enregistrerAcces(badge, zone, "Autorisé", raison);
    };

    public void refuserAcces(Badge badge, ZoneSecurisee zone, String raison) {

        UtilisateurCAN utilisateur = badge.getUtilisateur();

        System.out.println("Accés Refusé");
        System.out.println(" • Utilisateur : " + utilisateur.getNom() + " (ID: " + utilisateur.getId() + " )");
        System.out.println(" • Badge N° : " + badge.getNumeroBadge());

        if (zone != null) {
            System.out.println(" • Zone : " + zone.getNomZone());
            System.out.println(" • Niveau utilisateur : " + utilisateur.getNiveauAcces());
            System.out.println(" • Niveau requis : " + zone.getNiveauRequis());
        }

        System.out.println(" • Raison : " + raison);
        if (zone != null){
            enregistrerAcces(badge, zone,"Refus" ,raison);
        }
    }

    public void enregistrerAcces(Badge badge, ZoneSecurisee zone, String resultat, String raison) {
        AccesLog log = new AccesLog(badge, zone, resultat, raison);
        accesLog.add(log);
    };

    /********************************* Rapport************************ */

    // Calcule du teaux de refus
    public double calculerTauxRefus() {
        if (accesLog.isEmpty())
            return 0;

        int refus = 0;
        for (AccesLog log : accesLog) {
            if (log.getResultat().equalsIgnoreCase("refus"))
                refus++;
        }

        return (double) (refus * 100) / accesLog.size();
    }

    // Les 3 zones les plus sensible
    public ArrayList<ZoneSecurisee> getZonesPlusSensibles() {

        ArrayList<ZoneSecurisee> zonesSensibles = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ZoneSecurisee zoneMax = null;
            int maxRefus = 0;

            for (ZoneSecurisee zone : zones) {
                if (zonesSensibles.contains(zone)) {
                    continue;
                }

                int refus = 0;
                for (AccesLog log : accesLog) {
                    if (log.getResultat().equalsIgnoreCase("refus")) {
                        if (log.getZone() != null && log.getZone().getNomZone().equals(zone.getNomZone())) {
                            refus++;
                        }
                    }
                }

                if (refus > maxRefus) {
                    maxRefus = refus;
                    zoneMax = zone;
                }
            }

            if (zoneMax != null && maxRefus > 0) {
                zonesSensibles.add(zoneMax);
            }
        }

        return zonesSensibles;
    }

    public ArrayList<Badge> getBadgesPlusUtilises() {

        ArrayList<Badge> badgesUtilises = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Badge badgesMax = null;
            int maxUtilisation = 0;

            for (Badge badge : badges) {
                if (badgesUtilises.contains(badge)) {
                    continue;
                }

                int utilisation = 0;

                for (AccesLog log : accesLog) {
                    if (log.getBadge().getNumeroBadge() == badge.getNumeroBadge()) {
                        utilisation++;
                    }
                }

                if (utilisation > maxUtilisation) {
                    maxUtilisation = utilisation;
                    badgesMax = badge;
                }
            }

            if (badgesMax != null && maxUtilisation > 0) {
                badgesUtilises.add(badgesMax);
            }
        }

        return badgesUtilises;
    }

    // Affichage des Statistiques d'utilisateurs
    public void afficherStatistiquesUtilisateurs() {

        for (UtilisateurCAN utilisateur : utilisateurs) {
            int total = 0;
            int refus = 0;
            int succes = 0;

            for (AccesLog log : accesLog) {
                if (log.getBadge().getUtilisateur().equals(utilisateur)) {
                    total++;
                    if (log.getResultat().equalsIgnoreCase("refus")) {
                        refus++;
                    } else {
                        succes++;
                    }
                }
            }

            System.out.println("Utilisateur : " + utilisateur.getNom());
            System.out.println(" • Tentatives : " + total);
            System.out.println(" • Succès : " + succes);
            System.out.println(" • Refus : " + refus);
        }
    }

    // Affichages des statistiques des badges
    public void afficherStatistiquesBadges() {
        for (Badge badge : badges) {
            int total = 0;
            int refus = 0;
            int succes = 0;

            for (AccesLog log : accesLog) {
                if (log.getBadge().equals(badge)) {
                    total++;
                    if (log.getResultat().equalsIgnoreCase("refus")) {
                        refus++;
                    } else {
                        succes++;
                    }
                }
            }

            System.out.println("Badge N° : " + badge.getNumeroBadge());
            System.out.println(" • Utilisateur : " + badge.getUtilisateur().getNom());
            System.out.println(" • Tentatives : " + total);
            System.out.println(" • Succès : " + succes);
            System.out.println(" • Refus : " + refus);
        }
    }

    // Generer le rapport
    public void genererRapportComplet() {

        System.out.println("============RAPPORT DE SECURITE COMPLET============");

        // I don't know if we should keep this following block or not!!
        System.out.println("\n------ Statistiques générale ------");
        System.out.println("Utilisateurs enregistrés : " + utilisateurs.size());
        System.out.println("Badges générer : " + badges.size());
        System.out.println("Zones sécurisées : " + zones.size());

        System.out.println("------ Etat des badges ------");
        int actif = 0;
        int bloques = 0;
        int expires = 0;
        for (Badge badge : badges) {
            if (badge.getStatut().equals("bloque")) {
                bloques++;
            } else if (!badge.estBadgeValide()) {
                expires++;
            } else {
                actif++;
            }
        }
        System.out.println("Badge actifs : " + actif);
        System.out.println("Badges bloqués : " + bloques);
        System.out.println("Badges expirés : " + expires);

        System.out.println("Nombre total d'accès : " + accesLog.size());
        System.out.printf("Taux de refus : %.2f %%\n", calculerTauxRefus());

        System.out.println("\n------ Les Zones les plus sensibles ------");
        for (ZoneSecurisee zone : getZonesPlusSensibles()) {
            System.out.println(" • " + zone.getNomZone());
        }

        System.out.println("\n------ Les badges les plus utilisés ------");
        for (Badge badge : getBadgesPlusUtilises()) {
            System.out.println(" • Badge N° : " + badge.getNumeroBadge() + " de " + badge.getUtilisateur());
        }

        System.out.println("\n------ Les statistiques utilisateurs ------");
        afficherStatistiquesUtilisateurs();

        System.out.println("\n------ Les statistiques badges ------");
        afficherStatistiquesBadges();

        System.out.println("===================================================");
    }

    /**************************************
     * Access History & Logs Methods
     *************************************/
    // Liste des logs par zone
    public ArrayList<AccesLog> rechercherParZone(String nomZone)
            throws DonneeInvalideException, ZoneInterditeException {
        if (nomZone == null || nomZone.isEmpty() || nomZone.isBlank()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.nomvide();
            throw exception;
        }

        ZoneSecurisee zone = rechercherZone(nomZone);
        if (zone == null) {
            ZoneInterditeException exception = new ZoneInterditeException();
            exception.zoneInexistante();
            throw exception;
        }

        ArrayList<AccesLog> zoneLogs = new ArrayList<AccesLog>();
        System.out.println("Logs de la zone : " + zone.getNomZone());
        for (AccesLog aLog : accesLog) {
            if (aLog.getZone().getNomZone() == nomZone) {
                zoneLogs.add(aLog);

            }
        }
        return zoneLogs;
    }

    // Liste des logs par user
    public ArrayList<AccesLog> listerAccesParUtilisateur(int userId) {
        UtilisateurCAN user = rechercherPadId(userId);
        ArrayList<AccesLog> userLogs = new ArrayList<AccesLog>();

        System.out.println("Les tentatives de " + user.getNom());
        for (AccesLog aLog : accesLog) {
            if (aLog.getBadge().getUtilisateur().getId() == userId) {
                userLogs.add(aLog);
            }
        }
        return userLogs;
    }

    // Liste des logs par date
    public ArrayList<AccesLog> listerAccesParDate(LocalDate date) throws DonneeInvalideException {
        if (date == null) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.dateInvalide();
            throw exception;
        }

        ArrayList<AccesLog> dateLogs = new ArrayList<AccesLog>();
        System.out.println("Logs de la date : " + date);

        for (AccesLog eLog : accesLog) {
            if (eLog.getDate().equals(date)) {
                dateLogs.add(eLog);
            }
        }
        return dateLogs;
    }

    // Liste des logs par badge
    public ArrayList<AccesLog> listerAccesParBadge(int numeroBadge) throws BadgeInvalideException {
        Badge badge = rechercherParBadge(numeroBadge);
        ArrayList<AccesLog> badgeLogs = new ArrayList<AccesLog>();

        System.out.println("Logs de badge " + numeroBadge);
        for (AccesLog aLog : accesLog) {
            if (aLog.getBadge().equals(badge)) {
                badgeLogs.add(aLog);
            }
        }
        return badgeLogs;

    }

    // Liste des logs
    public void afficherHistorique() throws DonneeInvalideException {
        if (accesLog.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }

        System.out.println(
                "**************************************Historique Complet**************************************");
        System.out.println("Total : " + accesLog.size());
        for (AccesLog aLog : accesLog) {
            System.out.println("Date : " + aLog.getDate());
            System.out.println("Utilisateur : " + aLog.getBadge().getUtilisateur().getNom());
            System.out.println("Zone : " + aLog.getZone());
            System.out.println("Résultat : " + aLog.getResultat());
            if (aLog.getResultat().equals("Refus")) {
                System.out.println("Raison : " + aLog.getRaisonRefus());
            }
        }

    }

    // Trier Acces par date
    public void trierAccesParDate() throws DonneeInvalideException {
        if (accesLog.isEmpty()) {
            DonneeInvalideException exception = new DonneeInvalideException();
            exception.listeVide();
            throw exception;
        }

        accesLog.sort((aLog1, aLog2) -> {
            int dateCompare = aLog1.getDate().compareTo(aLog2.getDate());
            if (dateCompare != 0) {
                return dateCompare;
            }
            return aLog1.getTime().compareTo(aLog2.getTime());
        });

        for (AccesLog aLog : accesLog) {
            System.out.print("[Date : " + aLog.getDate() + " - " + aLog.getTime() + "] ");
            System.out.print("Badge : " + aLog.getBadge());
            System.out.println(" -> Zone : " + aLog.getZone());
            System.out.println("Résultat : " + aLog.getResultat());
            if (aLog.getResultat().equals("Refus")) {
                System.out.println("Raison : " + aLog.getRaisonRefus());
            }
        }
    }
}