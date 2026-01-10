package interfaces;
import java.time.LocalDate;

import models.UtilisateurCAN;

public interface Accreditable {
    
    public void genererBadge(UtilisateurCAN utilisateur, LocalDate dateDebut, LocalDate dateFin);
    public void invaliderBadge();
    public boolean estBadgeValide();

}
