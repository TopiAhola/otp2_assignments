package app.calculator;

public class Calculator {

    public double calculateConsumption(double distance, double consumption){
        return (consumption / 100) * distance;
    }
    public double calculateCost(double distance, double consumption, double price ){
        return calculateConsumption(distance, consumption) * price;
    }

}
