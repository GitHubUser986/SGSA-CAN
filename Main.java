import enums.CategorieSpectateur;
import enums.CategorieStaff;
import enums.CategorieVIP;
import exceptions.DonneeInvalideException;
import exceptions.ZoneInterditeException;
import models.SecurityService;
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
            
            ZoneSecurisee z1 = new ZoneSecurisee(1, "Entrée Générale", 1);
            ZoneSecurisee z2 = new ZoneSecurisee(2, "Tribune VIP", 3);
            ZoneSecurisee z3 = new ZoneSecurisee(3, "Zone Presse", 2);
            ZoneSecurisee z4 = new ZoneSecurisee(4, "Vestiaires", 2);
            ZoneSecurisee z5 = new ZoneSecurisee(5, "Salle de Contrôle", 3);
            
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
    }
}
