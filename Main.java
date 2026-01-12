import java.time.LocalDate;
import java.util.ArrayList;

import enums.CategorieSpectateur;
import enums.CategorieStaff;
import enums.CategorieVIP;
import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;
import models.SecurityService;
import models.Badge;
import models.Spectateur;
import models.Staff;
import models.VIP;
import models.ZoneSecurisee;

public class Main {
    public static void main(String[] args) {
        SecurityService service = new SecurityService();
        System.out.println("L'ajout des utilisateurs");
        // Test des utilisateurs
        try {
            Spectateur s1 = new Spectateur("Mohammed Ali", CategorieSpectateur.GRADIN_NORD);
            Spectateur s2 = new Spectateur("Fatima Hassan", CategorieSpectateur.GRADIN_SUD);
            Spectateur s3 = new Spectateur("Ahmed Benali", CategorieSpectateur.TRIBUNE_POPULAIRE);

            Staff st1 = new Staff("Karim Security", CategorieStaff.SECURITE);
            Staff st2 = new Staff("Sara Accueil", CategorieStaff.ACCUEIL);

            VIP v1 = new VIP("Omar President", CategorieVIP.PRESIDENTIEL);
            VIP v2 = new VIP("Amina Minister", CategorieVIP.CELEBRITY);

            service.ajouterUtilisateur(s1);
            service.ajouterUtilisateur(s2);
            service.ajouterUtilisateur(s3);
            service.ajouterUtilisateur(st1);
            service.ajouterUtilisateur(st2);
            service.ajouterUtilisateur(v1);
            service.ajouterUtilisateur(v2);

            System.out.println("\nTous les utilisateurs ont été ajoutés avec succès!\n");

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(st1);
            System.out.println(st2);
            System.out.println(v1);
            System.out.println(v2);

            System.out.println("****utilisateur ajoutés****");
            System.out.println("\n\n La liste des utilisateurs");
            service.listerUtilisateurs();

            System.out.println("\n\n La recherche du Mohammed Ali");
            service.rechercherParNom("Mohammed Ali");

            System.out.println("\n\n La recherche du Oumaima");
            service.rechercherParNom("Oumaima");

            System.out.println("\n\n La recherche de l'ID 1");
            service.rechercherPadId(1);
            service.rechercherPadId(33);

            System.out.println("Tri des utilisateurs");
            service.trierUtilisateurParNom();

            System.out.println("Comter par type");
            service.compterUtilisateurParType();

        } catch (DonneeInvalideException e) {
        }
    /******** Teste zones*********** */


        try {
            // 1. Ajouter des zones
            System.out.println("\n--- Ajout de zones sécurisées ---");
            
            ZoneSecurisee z1 = new ZoneSecurisee("Entrée Générale", 1);
            ZoneSecurisee z2 = new ZoneSecurisee("Tribune VIP", 3);
            ZoneSecurisee z3 = new ZoneSecurisee("Zone Presse", 2);
            ZoneSecurisee z4 = new ZoneSecurisee("Vestiaires", 2);
            ZoneSecurisee z5 = new ZoneSecurisee("Salle de Contrôle", 3);
            
            service.ajouterZone(z1);
            service.ajouterZone(z2);
            service.ajouterZone(z3);
            service.ajouterZone(z4);
            service.ajouterZone(z5);
            
            System.out.println("\n✓ 5 zones ajoutées avec succès!");
            
            // 2. Lister toutes les zones
            System.out.println("\n--- Liste de toutes les zones ---");
            for (ZoneSecurisee zone : service.listerZones()) {
                System.out.println(zone);
            }
            
            // 3. Rechercher une zone par nom
            System.out.println("\n--- Recherche de zone par nom ---");
            System.out.println("Recherche de 'Tribune VIP':");
            try {
                ZoneSecurisee zoneTrouvee = service.rechercherZone("Tribune VIP");
                System.out.println("Zone trouvée:");
                System.out.println(zoneTrouvee);
            } catch (ZoneInterditeException e) {
                System.out.println("Zone non trouvée");
            }
            
            System.out.println("\nRecherche d'une zone inexistante:");
            try {
                service.rechercherZone("Zone Fantôme");
            } catch (ZoneInterditeException e) {
                System.out.println("✓ Exception attrapée: Zone inexistante");
            }
            
            // 4. Rechercher une zone par ID
            System.out.println("\n--- Recherche de zone par ID ---");
            System.out.println("Recherche de la zone ID = 3:");
            try {
                ZoneSecurisee zoneTrouvee = service.rechercherZoneParId(3);
                System.out.println("Zone trouvée:");
                System.out.println(zoneTrouvee);
            } catch (ZoneInterditeException e) {
                System.out.println("Zone non trouvée");
            }
            
            System.out.println("\nRecherche d'un ID inexistant (999):");
            try {
                service.rechercherZoneParId(999);
            } catch (ZoneInterditeException e) {
                System.out.println("✓ Exception attrapée: ID de zone inexistant");
            }
            
            // 5. Trier les zones par niveau
            System.out.println("\n--- Tri des zones par niveau ---");
            System.out.println("Zones triées par niveau de sécurité:");
            for (ZoneSecurisee zone : service.trierZonesParNiveau()) {
                System.out.println(zone);
            }
            
            
        } catch (DonneeInvalideException  e) {
            System.out.println("Erreur: " + e.getMessage());
        }

            /******** Test badges*********** */

        System.out.println("/******** Test Badges Management*********** */");
        try {
            Spectateur s1 = new Spectateur("LHAZMIR ICHRAQ",CategorieSpectateur.GRADIN_NORD);
            Staff st1 = new Staff("Karim Security", CategorieStaff.SECURITE);
            Staff st2 = new Staff("Hiba Accueil",CategorieStaff.ACCUEIL);
            VIP v1 = new VIP("Omar Président",CategorieVIP.PRESIDENTIEL);

            service.ajouterUtilisateur(v1);
            service.ajouterUtilisateur(s1);
            service.ajouterUtilisateur(st1);
            service.ajouterUtilisateur(st2);

            // Générer des badges 
            System.out.println("\nTest 1 : Génération des badges");
            LocalDate today = LocalDate.now();
            LocalDate day30 = today.plusDays(30);
            LocalDate day60 = today.plusDays(60);
            LocalDate yesterday = today.minusDays(1);
            LocalDate dayMinus10 = today.minusDays(10);

            Badge badgeS1 = service.genererBadge(s1, today, day30);
            System.out.println("Badge : "+ badgeS1.getNumeroBadge()+ " est créé pour "+s1.getNom());
            System.out.println("Période : "+badgeS1.getDateDebut()+" - "+ badgeS1.getDateFin());
            System.out.println("Statut : "+badgeS1.getStatut());

            Badge badgeSt1 = service.genererBadge(st1, today, day60);
            Badge badgeV1 = service.genererBadge(v1, today, day30);
            Badge badgeSt2 = service.genererBadge(st2, dayMinus10, yesterday);

            System.out.println("\nTest 2 : Dates invalides");
            
            try {
                Badge badgeInvalide = service.genererBadge(s1, null, day30);
                
            } catch (DonneeInvalideException e) {
                
            }

            try {
                Badge badgeInvalide = service.genererBadge(s1, today, null);
                
            } catch (DonneeInvalideException e) {
                
            }

            // rechercher par num badge
            System.out.println("\nTest 3 : Recherche par num de badge");
            
            System.out.println("Test : Badge existant");
            try {
                Badge badgeTrouve = service.rechercherParBadge(badgeS1.getNumeroBadge());
                System.out.println("Numero " + badgeTrouve.getNumeroBadge());
                System.out.println("User : " + badgeTrouve.getUtilisateur().getNom());
                System.out.println("Statut : "+ badgeTrouve.getStatut());
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("Test : Badge Inexistant");
            try {
                Badge badgeInexistant = service.rechercherParBadge(9999);
                System.out.println("Numero " + badgeInexistant.getNumeroBadge());
                System.out.println("User : " + badgeInexistant.getUtilisateur().getNom());
                System.out.println("Statut : "+ badgeInexistant.getStatut());
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("\nTest 4 : Invalider badge");
            
            System.out.println("Test : Badge déjà expiré");
            try {
                service.invaliderBadge(badgeSt2.getNumeroBadge());
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("Test : Badge valide");
            try {
                service.invaliderBadge(badgeS1.getNumeroBadge());
                System.out.println("le badge est marqué comme expiré");
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("\nTest 5 : Bloquer un badge");

            System.out.println("Test : Bloquer un badge valide");
            try {
                service.bloquerBadge(badgeS1.getNumeroBadge(), st1);
            } catch (UnauthorizedException | BadgeInvalideException e) {
                
            }
            
            System.out.println("Test : Bloquer un badge déjà bloqué");
            
            try {
                service.bloquerBadge(badgeS1.getNumeroBadge(), st1);
            } catch (UnauthorizedException | BadgeInvalideException e) {
                
            }

            System.out.println("\nTest 6 : Débloquer badge");
            System.out.println("Test : Débloquer badge bloqué");
            try {
                service.debloquerBadge(badgeS1.getNumeroBadge(), st1);
            } catch (UnauthorizedException | BadgeInvalideException e) {
                
            }

            System.out.println("Test : Débloquer badge déjà débloqué");
            try {
                service.debloquerBadge(badgeS1.getNumeroBadge(), st1);
            } catch (UnauthorizedException | BadgeInvalideException e) {
                
            }

            System.out.println("\nTest 7 : Validité de badge");
            System.out.println("Test : validité de badge actif");
            try {
                service.verifierValiditeBadge(badgeS1);
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("Test : validité de badge expiré");
            try {
                service.verifierValiditeBadge(badgeSt2);
            } catch (BadgeInvalideException e) {
                
            }

            System.out.println("Test : Vérifier badge invalide");
            try {
                service.verifierValiditeBadge(null);
            } catch (BadgeInvalideException e) {
                
            }

            
            System.out.println("\nListe badges actifs");
            try {
                ArrayList<Badge> badgesActifs = service.listerBadgesActifs();
                System.out.println("Nombre des badges actifs : " +badgesActifs.size());
                for (Badge badge : badgesActifs) {
                    System.out.println("Badge :" +badge.getNumeroBadge() + "(" +badge.getUtilisateur().getNom() + ", "+ badge.getStatut()+")");
                }
            } catch (DonneeInvalideException e) {
                
            }

            System.out.println("\nListe badges bloqués");
            try {
                ArrayList<Badge> badgesBloques = service.listerBadgesBloques();
                System.out.println("Nombre des badges bloqués : " +badgesBloques.size());
                for (Badge badge : badgesBloques) {
                    System.out.println("Badge :" +badge.getNumeroBadge() + "(" +badge.getUtilisateur().getNom() + ", "+ badge.getStatut()+")");
                }
            } catch (DonneeInvalideException e) {
                
            }

            System.out.println("\nListe badges expirés");
            try {
                ArrayList<Badge> badgesExpires = service.listerBadgesExpires();
                System.out.println("Nombre des badges expirés : " +badgesExpires.size());
                for (Badge badge : badgesExpires) {
                    System.out.println("Badge :" +badge.getNumeroBadge() + "(" +badge.getUtilisateur().getNom() + ", "+ badge.getStatut()+")");
                }
            } catch (DonneeInvalideException e) {
                
            }

        } catch (Exception e) {
            System.out.println("Erreur de big TRY" + e.getMessage());
        }
    }
}
