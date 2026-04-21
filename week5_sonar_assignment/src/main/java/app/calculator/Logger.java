package app.calculator;

import java.util.ArrayList;

public class Logger {


    private Logger() {
    }

    static ArrayList<String> logs = new ArrayList<>();

    public static void log(Exception e){
        logs.add(e.getMessage());
    }

    public static void log(String message){
        logs.add(message);
    }
}
