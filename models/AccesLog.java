package models;

import java.time.LocalDateTime;

public class AccesLog {

    private LocalDateTime dateHeure;
    private Badge badge;
    private ZoneSecurisee zone;
    private String resultat;

    public AccesLog(Badge badge, ZoneSecurisee zone, String resultat) {
        this.dateHeure = LocalDateTime.now();
        this.badge = badge;
        this.zone = zone;
        this.resultat = resultat;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public ZoneSecurisee getZone() {
        return zone;
    }

    public void setZone(ZoneSecurisee zone) {
        this.zone = zone;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    
    
    
}

// AccesLog : dateHeure, badge, zone, resultat (OK/REFUS).