package edu.realemj.Exercises_04;

import java.util.*;

public class StringStats {
    public static void main(String [] args) {
        Scanner myInput = new Scanner(System.in);

        System.out.println("Enter word or number:");
        String s = myInput.next();
        System.out.println("You entered: " + s);
        int len = s.length();
        System.out.println("LENGTH: " + len);
        char third = s.charAt(2);
        System.out.println("THIRD CHAR: " + third);
        System.out.println("SHOUTING: " + s.toUpperCase());

    }    
}
