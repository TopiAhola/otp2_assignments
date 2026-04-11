package week4;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Create a week4.DatabaseConnection class including:
 * public class week4.DatabaseConnection {
 * private static final String URL = "jdbc:mysql://localhost:3306/fuel_calculator_localization";
 * private static final String USER = "root";
 * private static final String PASSWORD = "your_password";
 * public static Connection getConnection() throws SQLException {
 * return DriverManager.getConnection(URL, USER, PASSWORD);
 * }
 * }
 * • Database URL configuration
 * • Username and password (configurable via external properties file)
 * • Proper connection handling (open/close)
 * • Exception handling for connection failures
 */
public class DatabaseConnection {

        DriverManager driverManager;

    private DatabaseConnection() {
    }

    public static Connection getConnection(){
            try {
                //jdbc:mariadb://localhost:3306/otp2_week3
                String dbDriver = System.getenv("DB_DRIVER");
                String dbHost = System.getenv("DB_HOST");
                String dbPort = System.getenv("DB_PORT");
                String dbName = System.getenv("DB_NAME");
                String user = System.getenv("USER");
                String password = System.getenv("PASSWORD");

                if (dbDriver == null || dbHost == null || dbPort == null || dbName == null || user == null || password == null){
                    Logger.log( new Exception("Environmental variable not found"));
                }

                Logger.log(new Exception(dbDriver+"://"+dbHost+":"+dbPort+"/"+dbName) );
                return DriverManager.getConnection(dbDriver+"://"+dbHost+":"+dbPort+"/"+dbName , user, password);



            } catch (Exception e) {
                Logger.log(e);
                return null;
            }
        }



}
