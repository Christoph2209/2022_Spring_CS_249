package edu.realemj.Exercises_03;

import edu.realemj.Exercises_02.NPC;
import java.util.*;

public class FoodRationer {
    // These were just to demonstrate what
    // the default values of variables are.
    //private int x;
    //private double y;
    //private char c;
    //private NPC n;
    public static void main(String [] args) {
        // Ditto for above; not really part of
        // main exercise
        //FoodRationer r = new FoodRationer();
        //System.out.println("HELLO" + r);

        // Get data for calculation
        final double MEDIUM_RATIONS = 2.0;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of people:");
        int numPeople = input.nextInt(); // 5;
        double rations = MEDIUM_RATIONS;
        System.out.println("Enter total food:");
        double totalFood = input.nextDouble(); // 100.0;

        // Example of type casting
        int x = (int)1.0;

        // Converting from int to String via
        // String concatenation
        String numPeopleString = "PEOPLE CNT: " + numPeople;
        System.out.println(numPeopleString);

        // Calculate food per day
        double foodPerDay = rations * numPeople;

        // Calculate days left
        double daysLeft = totalFood / foodPerDay;
        System.out.println("DAYS LEFT: " + daysLeft);

        // Example of STDERR printout
        System.err.println("GO HOME!!!!");
        
        // Example of reading string chunks from Scanner
        //String first = input.next();
        //System.out.println("Before second...");
        //String second = input.next();
        //String third = input.next();
        //System.out.println(first + "," + second + "," + third);

        //var a = new ArrayList<StandardIntegerQueue>();
        



    }
    
}
