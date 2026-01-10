package interfaces;

import models.UtilisateurCAN;
import models.ZoneSecurisee;

public interface Securisable{

    public void autoriser(ZoneSecurisee zone, UtilisateurCAN utilisateur);
    public void refuser (ZoneSecurisee zone, UtilisateurCAN utilisateur);
    public boolean verifierAcces(ZoneSecurisee zone, UtilisateurCAN utilisateur);

}
