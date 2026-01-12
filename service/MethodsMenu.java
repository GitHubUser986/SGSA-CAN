package service;
import java.util.Scanner;

import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.ZoneInterditeException;
import models.SecurityService;

public class MethodsMenu {
    public SecurityService service = new SecurityService();

    public MethodsMenu() {
        
    }

    public void methodsMenuAjout(int operation) {
    
        switch(operation) {
            case 1:
                // Add user logic
                break;
            case 2:
                // Add zone logic
                break;
            case 3:
                // Generate badge logic
                break;
        }
    }

    public void methodsMenuAffichage(int operation) throws DonneeInvalideException{
        switch(operation) {
            case 1:
                service.listerUtilisateurs();
                break;
            case 2:
                service.listerZones();
                break;
            case 3:
                service.listerBadgesActifs();
                break;
            case 4:
                service.listerBadgesBloques();
                break;
            case 5:
                service.listerBadgesExpires();
                break;
        }
    }

    public void methodsMenuTri(int operation) throws DonneeInvalideException{
        switch(operation) {
            case 1:
                service.trierUtilisateurParNom();
                break;
            case 2:
                service.trierZonesParNiveau();
                break;
        }
    }

    public void methodsMenuRecherche(int operation) throws ZoneInterditeException, BadgeInvalideException{
        Scanner sc = new Scanner(System.in);
        switch(operation) {
            case 1:
                System.out.println("Entrer le nom : ");
                String nom = sc.nextLine();
                service.rechercherParNom(nom);
                break;
            case 2:
                System.out.println("Entrer le numéro : ");
                int id = sc.nextInt();
                service.rechercherPadId(id);
                break;
            case 3:
                System.out.println("Entrer le nom : ");
                String nomZone = sc.nextLine();
                service.rechercherZone(nomZone);
                break;
            case 4:
                System.out.println("Entrer le numéro : ");
                int idZone = sc.nextInt();
                service.rechercherZoneParId(idZone);
                break;
            case 5:
                System.out.println("Entrer le numéro : ");
                int idBadge = sc.nextInt();
                service.rechercherParBadge(idBadge);
                break;
        }

        sc.close();
    }

    public void methodsMenuGerer(int operation) {
        switch(operation) {
            case 1:
                // Block badge logic
                break;
            case 2:
                // Unblock badge logic
                break;
            case 3:
                // Invalidate badge logic
                break;
            case 4:
                // Check badge validity logic
                break;
        }
    }

    public void methodsMenuAutres(int operation) {
        switch(operation) {
            case 1:
                service.compterUtilisateurParType();
                break;
        }
    }

}
