package exceptions;

public class UnauthorizedException extends Exception {

    public UnauthorizedException(){
        super();
    }
    
    public void staffOnly(){
        System.out.println("Cette opération est réservée au staff");
    }

    public void vipOnly() {
        System.out.println("Cette opération est réservée au VIP");
    }

    public void securityOnly(){
        System.out.println("Seuls staff de sécurité autorisée à effectuer cette opération");
    }
}
