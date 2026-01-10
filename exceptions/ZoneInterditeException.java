package exceptions;

public class ZoneInterditeException extends Exception {

    public void zoneInexistante(){
        System.out.println("Zone inexistante");
    }

    public void zoneInterdite() {
        System.out.println("Zone interdite");
    }
    
}
