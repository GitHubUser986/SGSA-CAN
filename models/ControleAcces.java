package models;

import interfaces.Securisable;


public class ControleAcces implements Securisable {

    @Override
    public boolean verifierAcces(ZoneSecurisee zone, UtilisateurCAN utilisateur) {
        return false;
    }

    @Override
    public void autoriser(ZoneSecurisee zone, UtilisateurCAN utilisateur) {

    }

    @Override
    public void refuser(ZoneSecurisee zone, UtilisateurCAN utilisateur) {

    }

}
