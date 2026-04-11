package week4;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @Test
    void getConnection() {
        Connection c = DatabaseConnection.getConnection();
        assertNotNull(c);
    }
}