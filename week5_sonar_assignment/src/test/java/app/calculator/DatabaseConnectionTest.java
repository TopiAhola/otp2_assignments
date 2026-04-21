package app.calculator;

import app.calculator.DatabaseConnection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseConnectionTest {

    //@Disabled
    @Test
    void getConnection() {
        Connection c = DatabaseConnection.getConnection();
        assertNotNull(c);
    }
}