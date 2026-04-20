package org.example;

import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Give number of numbers:");
            int input = scanner.nextInt();
            Arrays.stream(getNumbers(input)).forEach(System.out::println) ;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bad number");
        }
    }


    public static String[] getNumbers(int input){
        String[] strings = new String[input];
        for (int i = 0; i < input; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            strings[i] = String.format( "i = %d", (i+1) );
        }
        return strings;
    }
}