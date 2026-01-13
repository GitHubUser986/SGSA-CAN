import java.util.Scanner;

import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;
import service.MethodsMenu;

public class Menu {
    public void afficherMenu() throws DonneeInvalideException, ZoneInterditeException, BadgeInvalideException, UnauthorizedException {
        MethodsMenu m = new MethodsMenu();
        int menu;
        int operation;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("------------------------Menu------------------------");
            System.out.println("1. Menu pour l'ajout");
            System.out.println("2. Menu pour l'affichage");
            System.out.println("3. Menu pour le tri");
            System.out.println("4. Menu pour la recherche");
            System.out.println("5. Menu pour la gestion");
            System.out.println("6. Menu pour autres opérations");
            System.out.println("0. Quitter l'application");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    do {
                        System.out.println("------------------------Ajout------------------------");
                        System.out.println("1. Ajouter un utilisateur");
                        System.out.println("2. Ajouter une zone");
                        System.out.println("3. Générer un badge");
                        System.out.println("0. Quitter le menu");
                        operation = sc.nextInt();
                        m.methodsMenuAjout(operation);
                    } while(operation != 0);
                    
                    break;
                case 2:
                    do {
                        System.out.println("----------------------Affichage----------------------");
                        System.out.println("1. Liste des utilisateurs");
                        System.out.println("2. Liste des zones");
                        System.out.println("3. Liste des badges actifs");
                        System.out.println("4. Liste des badges bloqués");
                        System.out.println("5. Liste des badges expirés");
                        System.out.println("0. Quitter le menu");
                        operation = sc.nextInt();
                        m.methodsMenuAffichage(operation);
                    } while(operation != 0);
        
                    break;
                case 3:
                    do {
                    System.out.println("-------------------------Tri-------------------------");
                    System.out.println("1. Trier les utilisateurs par nom");
                    System.out.println("2. Trier les zones par niveau");
                    System.out.println("0. Quitter le menu");
                        operation = sc.nextInt();
                        m.methodsMenuTri(operation);
                    } while(operation != 0);
                    break;
                case 4:
                     do {
                        System.out.println("----------------------Recherche----------------------");
                        System.out.println("1. Rechercher un utilisateur par son nom");
                        System.out.println("2. Rechercher un utilisateur par son numéro");
                        System.out.println("3. Rechercher une zone par son nom");
                        System.out.println("4. Rechercher une zone par son numéro");
                        System.out.println("5. Rechercher par numéro de badge");
                        System.out.println("0. Quitter le menu");
                            operation = sc.nextInt();
                            m.methodsMenuRecherche(operation);
                        } while(operation != 0);
                    break;
                case 5:
                     do {
                        System.out.println("-------------------------Gérer------------------------");
                        System.out.println("1. Bloquer un badge");
                        System.out.println("2. Débloquer un badge");
                        System.out.println("3. Invalider un badge");
                        System.out.println("4. Vérifier la validité du badge");
                        System.out.println("0. Quitter le menu");
                        operation = sc.nextInt();
                        m.methodsMenuGerer(operation);
                        } while(operation != 0);
                    break;
                case 6:
                     do {
                        System.out.println("-------------------------Autres------------------------");
                        System.out.println("1. Compter utilisateur par type (Spectateur, Staff, VIP)");
                        System.out.println("0. Quitter le menu");
                        operation = sc.nextInt();
                        m.methodsMenuAutres(operation);
                        } while(operation != 0);
                    break;
            
                default:
                    System.out.println("Cette option est introuvable");
                    break;
            }
        } while(menu != 0);

        sc.close();
        
    }
}
