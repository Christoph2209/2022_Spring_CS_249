package edu.realemj.Exercises_04;
import java.util.*;

public class FordCheck {
    public static void main(String [] args) {

        long seed = 42;
        Random r1 = new Random(seed);
        Random r2 = new Random(seed);

        for(int i = 0; i < 10; i++) {
            double n1 = r1.nextDouble();
            double n2 = r2.nextDouble();

            System.out.printf("%.5f\t%.5f\n", n1, n2);
        }

        int dice = r1.nextInt(6) + 1;
        System.out.println("You rolled a " + dice + "!");

        Random r = new Random(System.currentTimeMillis());
        boolean success = r.nextBoolean();

        if(success) {
            System.out.println("Got across safely!");
        }
        else {
            System.out.println("River too deep to ford!");
        }
    }
    
}
