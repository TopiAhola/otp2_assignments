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

        public static Connection getConnection(){
            try {

                //Class.forName("org.mariadb.jdbc.Driver");


                //jdbc:mariadb://localhost:3306/otp2_week3
                String DB_DRIVER = System.getenv("DB_DRIVER");
                String DB_HOST = System.getenv("DB_HOST");
                String DB_PORT = System.getenv("DB_PORT");
                String DB_NAME = System.getenv("DB_NAME");
                String USER = System.getenv("USER");
                String PASSWORD = System.getenv("PASSWORD");

                if (DB_DRIVER == null || DB_HOST == null || DB_PORT == null || DB_NAME == null || USER == null || PASSWORD == null){

                    /*Driver dr = DriverManager.getDriver("jdbc:mariadb://localhost:3306/otp2_week3");
                    Properties pr = new Properties();
                    pr.setProperty("user", "databaseuser");
                    pr.setProperty("password", "password");
                    Connection conn = dr.connect("jdbc:mariadb://localhost:3306/otp2_week3", pr);*/

                    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/otp2_week3?user=databaseuser&password=password");
                    return conn;
                }

                System.out.println(DB_DRIVER+"://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME);
                return DriverManager.getConnection(DB_DRIVER+"://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME , USER, PASSWORD);



            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }



}
