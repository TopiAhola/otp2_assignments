import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculateConsumption() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculateConsumption(0,0));
    }

    @Test
    void calculateCost() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.calculateCost(0,0, 0));
    }
}