import enums.CategorieSpectateur;
import enums.CategorieStaff;
import enums.CategorieVIP;
import exceptions.DonneeInvalideException;
import models.SecurityService;
import models.Spectateur;
import models.Staff;
import models.VIP;

public class BlockByblockTesting {
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║   SYSTÈME DE GESTION - CAN 2025                ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

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
            
        } catch (DonneeInvalideException e) {
        }

    //    System.out.println("========== TEST 2: EXCEPTION - NOM VIDE ==========\n");
    //     try {
    //         Spectateur sInvalide = new Spectateur("", CategorieSpectateur.GRADIN_NORD);
    //         service.ajouterUtilisateur(sInvalide);
            
    //     } catch (DonneeInvalideException e) {
    //     }

    // System.out.println("========== TEST 3: EXCEPTION - UTILISATEUR NULL ==========\n");
        
    //     try {
    //         service.ajouterUtilisateur(null);
    //         System.out.println("❌ ERREUR: Utilisateur null a été ajouté (ne devrait pas!)");
            
    //     } catch (DonneeInvalideException e) {
    //     }

    

    }
}
