package app.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    void logTest1() {
        assertDoesNotThrow( ()-> Logger.log(new Exception("exception!")));
    }

    @Test
    void logTest2() {
        assertDoesNotThrow( ()-> Logger.log("Message!"));
    }
}