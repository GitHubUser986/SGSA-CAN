package exceptions;

public class BadgeInvalideException extends Exception {

    public BadgeInvalideException() {
       super();
    }

    public void badgeInexistent() {
        System.out.println("Badge introuvable");
    }

    public void badgeBloque() {
        System.out.println("Badge bloqué");
    }

    public void badgeExpire(){
        System.out.println("Badge expiré");
    }
    
}
