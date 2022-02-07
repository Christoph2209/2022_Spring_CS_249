package edu.realemj.Exercises_05;
import java.util.*;

public class ShortCircuit {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        String type = input.next();
        String name = input.next();

        String lastName = null;
        // NOTE: ORDINARILY, DON'T SET STRING TO NULL!!!
        if(type.equals("Human")) {
            lastName = "Smith";
        }
        else if(type.equals("Dwarf")) {
            lastName = "Goodmountain";
        }
        else if(type.equals("Elf")) {
            lastName = "Greenleaf";
        }

        if(lastName != null && lastName.length() > 6) {
            System.out.println("That's a long name!");
        }

        System.out.println(type + " " + name + " " + lastName);

    }    
}
