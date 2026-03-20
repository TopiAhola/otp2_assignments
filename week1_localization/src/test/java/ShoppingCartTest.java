import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    static ShoppingCart shoppingCart;

    @BeforeAll
    static void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addToCart("A",5, 123.5);
        shoppingCart.addToCart("B",5, 123.5);
    }

    @Test
    void addToCart() {
        assertDoesNotThrow(() -> {
            shoppingCart.addToCart("c",5, 123.5);
            shoppingCart.addToCart("d",5, 123.5);
        });
    }

    @Test
    void testToString() {
        String a = """
        A   5   123.5   617,50
        B   5   123.5   617,50
        """;
        assertEquals(a, shoppingCart.toString());
    }

    @Test
    void getItemCount() {
        assertEquals(20, shoppingCart.getItemCount());
    }

    @Test
    void getTotalCost() {
        assertEquals(1235.0, shoppingCart.getTotalCost());
    }


}