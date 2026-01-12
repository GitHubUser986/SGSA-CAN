package exceptions;

public class AccesRefuseException extends Exception {

    public AccesRefuseException() {
        super();
    }
    
    public void afficher() {
        System.out.println("Vous n'êtes pas autorisé à accéder cette zone");
    }
}
