package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class AccesLog {

    private LocalDate date;
    private LocalTime time;
    private Badge badge;
    private ZoneSecurisee zone;
    private String resultat;
    private String raisonRefus;

    public AccesLog(Badge badge, ZoneSecurisee zone, String resultat, String raison) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.badge = badge;
        this.zone = zone;
        this.resultat = resultat;
        this.raisonRefus = raison;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime(){
        return time;
    }

    public void setTime(LocalTime time){
        this.time = time;
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

    public String getRaisonRefus(){
        return raisonRefus;
    }

    public void setRaisonRefus(String raisonRefus){
        this.raisonRefus = raisonRefus;
    }
    
}

// AccesLog : date, badge, zone, resultat (OK/REFUS).