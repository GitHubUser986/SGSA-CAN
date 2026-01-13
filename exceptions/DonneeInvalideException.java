package exceptions;

public class DonneeInvalideException extends Exception {

    public DonneeInvalideException() {
        super();
    }

    public void nomvide() {
        System.out.println("Nom est vide");
    }

    public void nomInvalide() {
        System.out.println("Nom est invalide");
    }

    public void nomLength(){
        System.out.println("Le nom doit être au minimum 2 caractères");
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

    public void startDateOnlyToday(){
        System.out.println("La date de début doit être aujourd'hui ou après");
    }

    public void intervalleInvalide(){
        System.out.println("La date de début doit être avant la date de fin");
    }

    public void duree365(){
        System.out.println("La durée raisonable de validité d'un badge ne doit pas passée 365 jours");
    }

    public void niveauInvalide(){
        System.out.println("Niveau invalide (doit être soit 1, 2 ou 3)");
    }

    public void listeVide() {
        System.out.println("La liste est vide");
    }
    
}
