package edu.soravic.Assign02;
import java.util.*;

public class VitalStats {
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        String name;
        String nameLast;
        int inches;
        int feet;
        int inches2;
        double weight;
        int BMI;

        System.out.println("Hello! Please enter your name: ");
        name = input.next();
        nameLast = input.next();
        System.out.println("Enter your height in inches: ");
        inches = input.nextInt();
        feet = inches / 12;
        inches2 = inches % 12;
        System.out.println("Enter your weight in pounds: ");
        weight = input.nextDouble();
        BMI = (703* (int)weight) / (inches *inches);
        input.close();
        System.out.println("NAME: " + nameLast + ", " + name);
        System.out.println("WEIGHT: "+ weight + " lbs.");
        System.out.println("HEIGHT: " + feet + "'" + inches2);
        System.out.println("BMI: " + BMI);

    }
}
