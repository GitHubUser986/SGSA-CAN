package exceptions;

public class DonneeInvalideException extends Exception {

    public void nomvide() {
        System.out.println("Nom est vide");
    }

    public void categorieInconnu() {
        System.out.println("Catégorie inconnue");
    }

    public void dateInvalide() {
        System.out.println("Date invalide");
    }
    
}
