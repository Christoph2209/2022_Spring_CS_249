package edu.soravic.Assign03;
import java.util.*;

public class CharGen {
        public static void main (String [] args)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter seed:");
            int seed = input.nextInt();
            Random rand = new Random(seed);
            boolean validName = true;
            do
            {
                System.out.println("Enter class:");
                String className = input.next().toUpperCase();
                if(className.equals("RANGER"))
                {
                    int strength = 50 + rand.nextInt(51);
                    int wisdom = 50 + rand.nextInt(51);
                    validName = true;
                    System.out.println("CLASS: " + className);
                    System.out.println("STRENGTH: " + strength);
                    System.out.println("WISDOM: "+ wisdom);
                }
                else if(className.equals("WIZARD"))
                {
                    int strength = 0 + rand.nextInt(51);
                    int wisdom = 50 + rand.nextInt(51);
                    validName = true;
                    System.out.println("CLASS: " + className);
                    System.out.println("STRENGTH: " + strength);
                    System.out.println("WISDOM: "+ wisdom);
                }
                else if(className.equals("WARRIOR"))
                {
                    int strength = 50 + rand.nextInt(51);
                    int wisdom = 0 + rand.nextInt(51);
                    validName = true;
                    System.out.println("CLASS: " + className);
                    System.out.println("STRENGTH: " + strength);
                    System.out.println("WISDOM: "+ wisdom);
                }
                else if(className.equals("PEASANT"))
                {
                    int strength = 0 + rand.nextInt(51);
                    int wisdom = 0 + rand.nextInt(51);
                    validName = true;
                    System.out.println("CLASS: " + className);
                    System.out.println("STRENGTH: " + strength);
                    System.out.println("WISDOM: "+ wisdom);
                }
                else
                {
                    System.err.println("UNKNOWN CLASS: " + className);
                    validName = false;
                }
            }while(validName == true);
        }
}
