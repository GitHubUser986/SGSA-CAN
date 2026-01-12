package exceptions;

public class DonneeInvalideException extends Exception {

    public DonneeInvalideException() {
        super();
    }

    public void nomvide() {
        System.out.println("Nom est vide");
    }

    public void utilisateurNull() {
        System.out.println("L'utilisateur est null");
    }

    public void categorieInconnu() {
        System.out.println("Catégorie inconnue");
    }

    public void dateInvalide() {
        System.out.println("Date invalide");
    }

    public void listeVide() {
        System.out.println("La liste est vide");
    }
    
}
