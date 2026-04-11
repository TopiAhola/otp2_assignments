package app.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationServiceTest {

    @Test
    void saveCalculationTest() {
        assertDoesNotThrow( ()-> CalculationService.saveCalculation(1,2,3,4,5,"en") );
    }
}