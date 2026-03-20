import java.io.BufferedInputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Locales
        Locale eng = new Locale("en", "UK");
        Locale fin = new Locale("fi","FI");
        Locale swe = new Locale("swe","SE");
        Locale jpn = new Locale("ja","JP");

        //ResourceBundles
        ResourceBundle english = ResourceBundle.getBundle("Localization", eng);
        ResourceBundle finnish = ResourceBundle.getBundle("Localization", fin);
        ResourceBundle swedish = ResourceBundle.getBundle("Localization", swe);
        ResourceBundle japanese = ResourceBundle.getBundle("Localization", jpn);
        ResourceBundle[] bundles = new ResourceBundle[] {english,finnish,swedish,japanese};

        //Create Shopping Cart
        ShoppingCart shoppingCart = new ShoppingCart();

        //Create menu
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input, bundles, shoppingCart);

        //run menu
        boolean run = true;
        while(run) {
                run = menu.runState();
        }


    }
}
