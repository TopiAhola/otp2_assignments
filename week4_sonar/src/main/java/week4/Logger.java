package week4;

import java.util.ArrayList;

public class Logger {


    private Logger() {
    }

    static ArrayList<String> logs = new ArrayList<>();

    public static void log(Exception e){
        try {
            logs.add(e.getMessage());

        } catch (Exception ex) {
            logs.add(ex.getMessage());
        }
    }

    public static void log(String message){
        logs.add(message);
    }
}
