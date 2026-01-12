package service;
import java.util.Scanner;

import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;
import models.SecurityService;
import models.UtilisateurCAN;
import models.Badge;

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
                try {
                    service.listerZones();
                    break;
                } catch (DonneeInvalideException e) {

                }
            case 3:
                try {
                    service.listerBadgesActifs();
                    break;
                } catch (DonneeInvalideException e) {

                }
            case 4:
                try {
                    service.listerBadgesBloques();
                    break;
                } catch (DonneeInvalideException e) {

                }
            case 5:
                try {
                    service.listerBadgesExpires();
                    break;
                } catch (DonneeInvalideException e) {

                }
        }
    }

    public void methodsMenuTri(int operation) throws DonneeInvalideException{
        switch(operation) {
            case 1:
                service.trierUtilisateurParNom();
                break;
            case 2:
                try {
                    service.trierZonesParNiveau();
                    break;
                } catch (DonneeInvalideException e) {
                    
                }
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
                try {
                    System.out.println("Entrer le nom : ");
                    String nomZone = sc.nextLine();
                    service.rechercherZone(nomZone);
                    break;
                } catch (ZoneInterditeException e) {
                    
                }
            case 4:
                try {
                    System.out.println("Entrer le numéro : ");
                    int idZone = sc.nextInt();
                    service.rechercherZoneParId(idZone);
                    break;
                } catch (ZoneInterditeException e) {
                    
                }
            case 5:
                try {
                    System.out.println("Entrer le numéro : ");
                    int idBadge = sc.nextInt();
                    service.rechercherParBadge(idBadge);
                    break;
                } catch (BadgeInvalideException e) {
                    
                }
        }
        sc.close();
    }

    public void methodsMenuGerer(int operation) throws UnauthorizedException, BadgeInvalideException{
        Scanner sc = new Scanner(System.in);
        switch(operation) {
            case 1:
                try {
                    System.out.println("Entrer votre id :");
                    int id = sc.nextInt();
                    UtilisateurCAN user = service.rechercherPadId(id);
                    System.out.println("Entrer le numéro du badge à bloquer : ");
                    int numeroBadgeBloque = sc.nextInt();
                    service.bloquerBadge(numeroBadgeBloque, user);
                    break;
                } catch (UnauthorizedException | BadgeInvalideException e) {

                }
            case 2:
                try {
                    System.out.println("Entrer votre id :");
                    int idUser = sc.nextInt();
                    UtilisateurCAN userAdmin = service.rechercherPadId(idUser);
                    System.out.println("Entrer le numéro du badge à bloquer : ");
                    int numeroBadgeDebloque = sc.nextInt();
                    service.debloquerBadge(numeroBadgeDebloque, userAdmin);
                    break;
                } catch (UnauthorizedException | BadgeInvalideException e) {

                }
            case 3:
                try {
                    System.out.println("Entrer le numéro de badge : ");
                    int numero = sc.nextInt();
                    service.invaliderBadge(numero);
                    break;
                } catch (BadgeInvalideException e) {

                }
            case 4:
                try {
                    System.out.println("Entrer le numéro de badge : ");
                    int idBadge = sc.nextInt();
                    Badge badge = service.rechercherParBadge(idBadge);
                    service.verifierValiditeBadge(badge);
                    break;
                } catch (BadgeInvalideException e) {

                }
        }
        sc.close();
    }

    public void methodsMenuAutres(int operation) {
        switch(operation) {
            case 1:
                service.compterUtilisateurParType();
                break;
        }
    }

}
