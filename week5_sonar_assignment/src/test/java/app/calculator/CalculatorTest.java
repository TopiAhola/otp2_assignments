package app.calculator;

import app.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void calculateConsumption() {
        Calculator calculator = new Calculator();
        assertEquals(0.4, calculator.calculateConsumption(5,8));
    }

    @Test
    void calculateCost() {
        Calculator calculator = new Calculator();
        assertEquals(0.27, calculator.calculateCost(3,6, 1.5));
    }

    @Test
    void nan() {
        Calculator calculator = new Calculator();
        assertDoesNotThrow(()-> calculator.calculateConsumption(Double.NaN,Double.NaN));

    }


}

