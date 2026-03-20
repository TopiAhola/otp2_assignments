import java.util.*;

public class Menu {

    Scanner scanner;
    ResourceBundle currentBundle;
    ResourceBundle[] bundles;
    MenuState currentState;
    ShoppingCart shoppingCart;
    List<String> exitWords;
    MenuState[] menuStates;

    public Menu(Scanner input, ResourceBundle[] bundles, ShoppingCart shoppingCart) {
        this.scanner = input;
        this.bundles = bundles;
        currentBundle = bundles[0];
        currentState = languageMenu;
        this.shoppingCart = shoppingCart;
        this.exitWords = new ArrayList<>();
        for(ResourceBundle rb : bundles){
            exitWords.add(rb.getString("exitWord"));
        }
        menuStates = new MenuState[]{baseMenu,additems,contentsMenu,languageMenu};
    }

    public boolean runState(){
            return  currentState.execute();
    }

    private void printCartStats(){
        System.out.println( currentBundle.getString("cartInfoString1") +" " + shoppingCart.getItemCount() );
        System.out.println( currentBundle.getString(
                "cartInfoString2") + " "
                + String.format("%03.2f",shoppingCart.getTotalCost())
                + currentBundle.getString("currency")
        );
    }



    @FunctionalInterface
    interface MenuState{
        public boolean execute();
    }

    /// //////////////////////////////////////////////////////
    MenuState baseMenu = ()->{
        printCartStats();
        System.out.println( currentBundle.getString("baseMenu") );

        String line = scanner.nextLine().trim().toLowerCase();
        System.out.println("Input: " + line);
        if(exitWords.contains(line)){
            return false;
        }

        switch(line){
            case "1": {currentState = menuStates[1];} break;
            case "2": {currentState = menuStates[2];} break;
            case "3": {currentState = menuStates[3];} break;

        }

        return true;
    };

    /// //////////////////////////////////////////////////////
    MenuState additems = ()->{
        printCartStats();
        System.out.println(currentBundle.getString("addMenu"));

        String itemAdded = null;
        int quantity = 0;
        double cost = 0.0;

        String line = scanner.nextLine().trim().toLowerCase();
        System.out.println("Input: " + line);
        if(exitWords.contains(line)){
            return false;

        } else if(line.isBlank()){
            currentState = baseMenu;
            return true;

        } else {
            //process adding item
            itemAdded = line;
            System.out.println(currentBundle.getString("quantityPrompt"));
            String quentityString = scanner.nextLine().trim().toLowerCase();
            try{
                quantity = Integer.parseInt(quentityString);

            } catch(NumberFormatException e){
                e.printStackTrace();
                currentState = baseMenu;
                return true;
            }

            if(quantity <= 0){
                currentState = baseMenu;
                return true;
            }

            System.out.println(currentBundle.getString("costPrompt"));
            String costString = scanner.nextLine().trim().toLowerCase();
            try{
                cost = Double.parseDouble(costString);

            } catch(NumberFormatException e){
                e.printStackTrace();
                currentState = baseMenu;
                return true;
            }
            //add item remain here
            shoppingCart.addToCart(itemAdded, quantity, cost);
            System.out.println(itemAdded + " " + quantity + " " + cost );
            return  true;
        }
    };

    /// //////////////////////////////////////////////////////
    MenuState contentsMenu = ()->{
        printCartStats();
        System.out.println(currentBundle.getString("contentsMenu"));
        System.out.println(shoppingCart.toString());

        String line = scanner.nextLine().trim().toLowerCase();
        System.out.println("Input: " + line);
        if(exitWords.contains(line)){
            return false;

        }  else {
            currentState = baseMenu;
        }

        return true;
    };

    /// //////////////////////////////////////////////////////
    MenuState languageMenu = ()->{
        System.out.println(currentBundle.getString("languageMenu"));


        String line = scanner.nextLine().trim().toLowerCase();
        System.out.println("Input: " + line);
        if(exitWords.contains(line)){
            return false;
        }

        switch(line){
            case "1": {currentBundle = bundles[0];} break;
            case "2": {currentBundle = bundles[1];} break;
            case "3": {currentBundle = bundles[2];} break;
            case "4": {currentBundle = bundles[3];} break;
        }
        //return to main menu
        currentState = baseMenu;

        return true;
    };


}



/*
Objective: Create a Java console application that performs the following tasks:
1. Prompt the user to enter the number of items they want to purchase.
2. For each item, ask the user for the price and quantity.
3. Calculate the total cost of each item (price × quantity).
4. Calculate the total cost of all items in the shopping cart.
5. Display the total cost of the shopping cart to the user.
6. Implement localization so that the program can display messages in Finnish, Swedish, and English based
on the user's language selection.
 */