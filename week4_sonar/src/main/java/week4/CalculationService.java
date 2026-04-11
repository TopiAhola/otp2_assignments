package week4;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
        Create a class that connects to MySQL/MariaDB and stores calculation records:
    • Save calculation record (distance, consumption, price, total fuel, total cost, language)
    • Handle database connection properly
    • Use prepared statements to prevent SQL injection
    • Implement proper error handling
    Required Methods:
    • saveCalculation(CalculationRecord record) – saves a calculation record
    • getConnection() – establishes database connection

    */
public class CalculationService {


     public static void saveCalculation(double distance, double consumption, double price, double total_fuel, double total_cost, String language){
        try (
                Connection connection = week4.DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO calculation_records(distance, consumption, price, total_fuel, total_cost, language) VALUES (?, ?, ?, ?, ?, ?)");
            ) {

            statement.setDouble(1,distance);
            statement.setDouble(2,consumption);
            statement.setDouble(3,price);
            statement.setDouble(4,total_fuel);
            statement.setDouble(5,total_cost);
            statement.setString(6,language);
            statement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
