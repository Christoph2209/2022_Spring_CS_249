package edu.soravic.Assign03;
import java.util.*;

public class LOTRQuiz {
    public static void main (String [] args)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter strength and wisdom:");
            int strength = input.nextInt();
            int wisdom = input.nextInt();
            if (strength < 0 || wisdom < 0)
            {
                System.err.println("ERROR: Negative entry!");
            }
            else if (strength >= 50 && wisdom >= 50)
            {
                    System.out.println("ARAGORN!");
            }
            else if (strength >= 50 && wisdom < 50)
            {
                    System.out.println("BOROMIR!");
            }
            else if (strength < 50 && wisdom >= 50)
            {
                    System.out.println("GANDALF!");
            }
            else if (strength < 50 && wisdom < 50)
            {
                    System.out.println("GOLLUM!");
            }
        }
}
