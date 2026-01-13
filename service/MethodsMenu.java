package service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import enums.CategorieSpectateur;
import enums.CategorieStaff;
import enums.CategorieVIP;
import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;
import models.SecurityService;
import models.Spectateur;
import models.Staff;
import models.UtilisateurCAN;
import models.VIP;
import models.ZoneSecurisee;
import models.AccesLog;
import models.Badge;

public class MethodsMenu {
    public SecurityService service = new SecurityService();

    public MethodsMenu() {
        
    }

    public void methodsMenuAjout(int operation) throws DonneeInvalideException{
        Scanner sc = new Scanner(System.in);
        switch(operation) {
            case 1:
                try {
                    System.out.println("Entrez le nom complet de l'utilisateur");
                    String nom = sc.nextLine();
                    System.out.println("Cet utilisateur est-il (1: Spectateur, 2: Staff, 3: VIP)?");
                    int categorie = sc.nextInt();
                    if(categorie == 1) {
                        System.out.println("Quelle est sa catégorie : (1: Tribune populaire, 2: Tribune VIP, 3: Gradin nord, 4: Gradin sud)");
                        int categorieSpectateur = sc.nextInt();
                        if(categorieSpectateur == 1) {
                            Spectateur user = new Spectateur(nom,CategorieSpectateur.TRIBUNE_POPULAIRE);
                            service.ajouterUtilisateur(user);
                        } else if(categorieSpectateur == 2) {
                            Spectateur user = new Spectateur(nom,CategorieSpectateur.TRIBUNE_VIP);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieSpectateur == 3) {
                            Spectateur user = new Spectateur(nom,CategorieSpectateur.GRADIN_NORD);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieSpectateur == 4) {
                            Spectateur user = new Spectateur(nom,CategorieSpectateur.GRADIN_SUD);
                            service.ajouterUtilisateur(user);
    
                        } else {
                            System.out.println("Catégorie incorrecte");
                        }
                        
                    } else if(categorie == 2){
                         System.out.println("Quelle est sa catégorie : (1: Sécurité, 2: Médicale, 3: Technique, 4: Accueil, 5: Maintenance, 6: Restauration, 7: Media)");
                        int categorieStaff = sc.nextInt();
                        if(categorieStaff == 1) {
                            Staff user = new Staff(nom,CategorieStaff.SECURITE);
                            service.ajouterUtilisateur(user);
                        } else if(categorieStaff == 2) {
                            Staff user = new Staff(nom,CategorieStaff.MEDICAL);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieStaff == 3) {
                            Staff user = new Staff(nom,CategorieStaff.TECHNIQUE);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieStaff == 4) {
                            Staff user = new Staff(nom,CategorieStaff.ACCUEIL);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieStaff == 5) {
                            Staff user = new Staff(nom,CategorieStaff.MAINTENANCE);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieStaff == 6) {
                            Staff user = new Staff(nom,CategorieStaff.RESTAURATION);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieStaff == 7) {
                            Staff user = new Staff(nom,CategorieStaff.MEDIA);
                            service.ajouterUtilisateur(user);
    
                        } else {
                            System.out.println("Catégorie incorrecte");
                        }
                    } else if(categorie == 3) {
                        System.out.println("Quelle est sa catégorie : (1: Présidentiel, 2: Délegation officielle, 3: Sponsores, 4: FIFA CAF, 5: Ambassadeurs, 6: Celebrity, 7: Presse Internationale)");
                        int categorieVIP = sc.nextInt();
                        if(categorieVIP == 1) {
                            VIP user = new VIP(nom,CategorieVIP.PRESIDENTIEL);
                            service.ajouterUtilisateur(user);
                        } else if(categorieVIP == 2) {
                            VIP user = new VIP(nom,CategorieVIP.DELEGATION_OFFICIELLE);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieVIP == 3) {
                            VIP user = new VIP(nom,CategorieVIP.SPONSORS);
                            service.ajouterUtilisateur(user);
    
                        } else if(categorieVIP == 4) {
                            VIP user = new VIP(nom,CategorieVIP.FIFA_CAF);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieVIP == 5) {
                            VIP user = new VIP(nom,CategorieVIP.AMBASSADEURS);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieVIP == 6) {
                            VIP user = new VIP(nom,CategorieVIP.CELEBRITY);
                            service.ajouterUtilisateur(user);
                        
                        } else if(categorieVIP == 7) {
                            VIP user = new VIP(nom,CategorieVIP.PRESSE_INTERNATIONALE);
                            service.ajouterUtilisateur(user);
    
                        } else {
                            System.out.println("Catégorie incorrecte");
                        }
                    } else {
                        System.out.println("Catégorie incorrecte");
                    }
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 2:
                System.out.println("Entrez le nom de la zone : ");
                String nomZone = sc.nextLine();
                System.out.println("Entrez le niveau requis à entrer cette zone : (1: Spectateur, 2: Staff, 3: VIP)");
                int niveau = sc.nextInt();
                ZoneSecurisee zone = new ZoneSecurisee(nomZone, niveau);
                service.afficherZone(zone);
                break;
            case 3:
                try {
                    System.out.println("Entrez l'identifiant de l'utilisateur : ");
                    int id = sc.nextInt();
                    UtilisateurCAN user = service.rechercherPadId(id);
                    System.out.println("Entrez la date de début de validation de ce badge ");
                    String dateInput = sc.nextLine();
                    LocalDate debut = LocalDate.parse(dateInput);
                    System.out.println("Entrez la date de fin de validation de ce badge ");
                    dateInput = sc.nextLine();
                    LocalDate fin = LocalDate.parse(dateInput);
                    service.genererBadge(user, debut, fin);
                    
                } catch (DonneeInvalideException e) {
                }
                break;
            default : 
                System.out.println("Option incorrecte");
                break;
        }
        sc.close();
    }

    public void methodsMenuAffichage(int operation) throws DonneeInvalideException, ZoneInterditeException{
        Scanner sc = new Scanner(System.in);
        switch(operation) {
            case 1:
                service.listerUtilisateurs();
                break;
            case 2:
                try {
                    service.listerZones();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 3:
                try {
                    service.listerBadgesActifs();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 4:
                try {
                    service.listerBadgesBloques();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 5:
                try {
                    service.listerBadgesExpires();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 6: 
                System.out.println("Entrez l'identifiant de l'utilisateur : ");
                int id = sc.nextInt();
                ArrayList<AccesLog> userLogs = service.listerAccesParUtilisateur(id);
                for (AccesLog accesLog : userLogs) {
                    System.out.println("Zone : "+ accesLog.getZone() + " Résultat : "+ accesLog.getResultat());
                }
                break;
            case 7: 
                try {
                    System.out.println("Entrez la date : ");
                    String dateInput = sc.nextLine();
                    LocalDate date = LocalDate.parse(dateInput);
                    ArrayList<AccesLog> dateLogs = service.listerAccesParDate(date);
                    for (AccesLog accesLog : dateLogs) {
                        System.out.println(accesLog.getBadge().getUtilisateur().getNom() + " -> " + accesLog.getZone().getNomZone() +" : "+accesLog.getResultat());
                    }
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 8:
                try {
                    System.out.println("Entrez le nom de la zone : ");
                    String nomZone = sc.nextLine();
                    ArrayList<AccesLog> accesLogs =  service.rechercherParZone(nomZone);
                    for (AccesLog accesLog : accesLogs) {
                        System.out.println("["+ accesLog.getDate() + " - "+ accesLog.getTime() + "]");
                        System.out.println(accesLog.getBadge().getUtilisateur().getNom() + " : " + accesLog.getResultat());
                    }
                } catch (DonneeInvalideException | ZoneInterditeException e) {
                    
                }
                break;
            case 9:
                try {
                System.out.println("Entrez le numero de badge : ");
                int numeroBadge = sc.nextInt();
                ArrayList<AccesLog> badgeLogs = service.listerAccesParBadge(numeroBadge);
                for (AccesLog accesLog : badgeLogs) {
                    System.out.println("Zone : "+ accesLog.getZone().getNomZone() + " Résultat : "+accesLog.getResultat());
                    if(accesLog.getResultat().equals("Refus")){
                        System.out.println("Raison : "+accesLog.getRaisonRefus());
                    }
                }
                break;
            } catch (BadgeInvalideException e) {
               
            }
            case 10:
                try {
                    service.afficherHistorique();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case  11:
                System.out.println("Entrez l'identifiant de l'utilisateur : ");
                int idUser = sc.nextInt();
                UtilisateurCAN user = service.rechercherPadId(idUser);
                service.afficherUtilisateur(user);
                break;
            case 12:
                try {
                    System.out.println("Entrez le numero de badge : ");
                    int numeroBadge = sc.nextInt();
                    Badge badge = service.rechercherParBadge(numeroBadge);
                    service.afficherBadge(badge);
                } catch (BadgeInvalideException e) {
                    
                }
                break;
            case 13:
                try {
                    System.out.println("Entrez le nom de la zone : ");
                    String nomZone = sc.nextLine();
                    ZoneSecurisee zone = service.rechercherZone(nomZone);
                    service.afficherZone(zone);
                } catch (ZoneInterditeException e) {
                    
                }
                break;
            default:
                System.out.println("Option incorrecte");
                break;

        }
        sc.close();
    }

    public void methodsMenuTri(int operation) throws DonneeInvalideException{
        switch(operation) {
            case 1:
                service.trierUtilisateurParNom();
                break;
            case 2:
                try {
                    service.trierZonesParNiveau();
                } catch (DonneeInvalideException e) {
                    
                }
                break;
            case 3:
                try {
                    service.trierAccesParDate();
                } catch (DonneeInvalideException e) {

                }
                break;
            default:
                System.out.println("Option incorrecte");
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
                try {
                    System.out.println("Entrer le nom : ");
                    String nomZone = sc.nextLine();
                    service.rechercherZone(nomZone);
                } catch (ZoneInterditeException e) {
                    
                }
                break;
            case 4:
                try {
                    System.out.println("Entrer le numéro : ");
                    int idZone = sc.nextInt();
                    service.rechercherZoneParId(idZone);
                } catch (ZoneInterditeException e) {
                    
                }
                break;
            case 5:
                try {
                    System.out.println("Entrer le numéro : ");
                    int idBadge = sc.nextInt();
                    service.rechercherParBadge(idBadge);
                } catch (BadgeInvalideException e) {
                    
                }
                break;
            default:
                System.out.println("Option incorrecte");
                break;
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
                } catch (UnauthorizedException | BadgeInvalideException e) {
                    
                }
                break;
            case 2:
                try {
                    System.out.println("Entrer votre id :");
                    int idUser = sc.nextInt();
                    UtilisateurCAN userAdmin = service.rechercherPadId(idUser);
                    System.out.println("Entrer le numéro du badge à bloquer : ");
                    int numeroBadgeDebloque = sc.nextInt();
                    service.debloquerBadge(numeroBadgeDebloque, userAdmin);
                } catch (UnauthorizedException | BadgeInvalideException e) {
                    
                }
                break;
            case 3:
                try {
                    System.out.println("Entrer le numéro de badge : ");
                    int numero = sc.nextInt();
                    service.invaliderBadge(numero);
                } catch (BadgeInvalideException e) {
                    
                }
                break;
            case 4:
                try {
                    System.out.println("Entrer le numéro de badge : ");
                    int idBadge = sc.nextInt();
                    Badge badge = service.rechercherParBadge(idBadge);
                    service.verifierValiditeBadge(badge);
                } catch (BadgeInvalideException e) {
                    
                }
                break;
            case 5:
                try {
                    System.out.println("Entrer le numéro de badge : ");
                    int idBadge = sc.nextInt();
                    System.out.println("Entrez le nom de la zone");
                    String nomZone = sc.nextLine();
                    boolean resutat = service.verfierAcces(idBadge, nomZone);
                    if(resutat) {
                        System.out.println("Vous êtes autorisé à entrer à cette zone");
                    } else {
                        System.out.println("Vous n'êtes pas autorisé à entrer à cette zone");

                    }
                } catch (BadgeInvalideException e) {
                    
                }
                break;
            default:
                System.out.println("Option incorrecte");
                break;
        }
        sc.close();
    }

    public void methodsMenuAutres(int operation) throws DonneeInvalideException, ZoneInterditeException, UnauthorizedException{
        Scanner sc = new Scanner(System.in);
        switch(operation) {
            case 1:
                service.compterUtilisateurParType();
                break;
            case 2:
                try {
                    System.out.println("Entrez le nom : ");
                    String nom = sc.nextLine();
                    System.out.println("Entrez la catégorie : ");
                    String categorie = sc.nextLine();
                    service.validerDonneesUtilisateur(nom, categorie);

                } catch (DonneeInvalideException e) {

                }
                break;
            case 3:
                try {
                    System.out.println("Entrez le nom : ");
                    String nomZone = sc.nextLine();
                    System.out.println("Entrez le numéro de niveau : ");
                    int niveau = sc.nextInt();
                    service.validerDonneesZone(nomZone, niveau);
                    
                } catch (DonneeInvalideException | ZoneInterditeException e) {

                }
                break;
            case 4: 
                try {
                    System.out.println("Entrez la de début : ");
                    String dateInput = sc.nextLine();
                    LocalDate debut = LocalDate.parse(dateInput);
                    System.out.println("Entrez la date de fin : ");
                    dateInput = sc.nextLine();
                    LocalDate fin = LocalDate.parse(dateInput);
                    service.validerDonneesBadge(debut, fin);

                } catch (DonneeInvalideException e) {

                }
                break;
            case 5:
                try {
                    System.out.println("Entrer votre id :");
                    int id = sc.nextInt();
                    UtilisateurCAN user = service.rechercherPadId(id);
                    Staff staff = (Staff) user;
                    service.verifierDroitsBlocage(staff);
                } catch (UnauthorizedException | DonneeInvalideException e) {
                   
                }
                break;
            default:
                System.out.println("Option incorrecte");
                break;
        }
        sc.close();
    }

    public void methodsMenuRapports(int operation){
        switch (operation) {
            case 1:
                service.genererRapportComplet();
                break;
        
            default:
                System.out.println("Option incorrecte");
                break;
        }
    }

}
