import java.util.ArrayList;

public class ShoppingCart {

    class ShoppingCartItem {
        public String itemName;
        public int quantity;
        public double unitCost;

        public ShoppingCartItem(String itemName, int quantity, double unitCost) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.unitCost = unitCost;
        }
        @Override
        public String toString() {
            double cost = unitCost * quantity;
            return itemName + "   " + quantity + "   " + unitCost + "   " + String.format("%03.2f", cost);
        }

    }

    public ArrayList<ShoppingCartItem> shoppingCartItems;

    public ShoppingCart() {
        this.shoppingCartItems = new ArrayList<>();
    }



    public void addToCart(String itemName, int quantity, double unitCost){
        shoppingCartItems.add(new ShoppingCartItem(itemName, quantity, unitCost));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ShoppingCartItem item : shoppingCartItems) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    public int getItemCount(){
        return this.shoppingCartItems.stream()
                .mapToInt(shoppingCartItem -> shoppingCartItem.quantity)
                .sum();

    }

    public double getTotalCost(){
        return this.shoppingCartItems.stream()
                .mapToDouble(item-> item.quantity * item.unitCost )
                .sum();
    }



}
