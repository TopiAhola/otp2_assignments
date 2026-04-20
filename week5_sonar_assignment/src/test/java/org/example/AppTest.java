package org.example;

import java.util.Arrays;

import static org.example.App.getNumbers;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    void getNumbersTest() {
        String[] result = getNumbers(4);
        assertEquals(4, result.length);
        assertEquals(Arrays.toString(new String[]{"i = 1","i = 2","i = 3","i = 4"}), Arrays.toString(result) );
    }
}