import exceptions.BadgeInvalideException;
import exceptions.DonneeInvalideException;
import exceptions.UnauthorizedException;
import exceptions.ZoneInterditeException;

public class Main {
    public static void main(String[] args) throws DonneeInvalideException, ZoneInterditeException, BadgeInvalideException, UnauthorizedException{
        Menu menu = new Menu();

        menu.afficherMenu();
    }
}
