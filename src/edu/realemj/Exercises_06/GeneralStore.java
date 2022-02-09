package edu.realemj.Exercises_06;
import java.util.*;

public class GeneralStore {

    public static void main(String [] args) {
        Supplies supplies = new Supplies();

        Scanner input = new Scanner(System.in);

        boolean validItem = true;

        System.out.println("Welcome to Mr. Do-While's General Store!");

        do {
            System.out.println("What do you want to buy?");
            int value = input.nextInt();
            String item = input.next();
            item = item.toLowerCase();

            switch(item) {
                case "food" -> supplies.addFood(value); //supplies.setTotalFood(supplies.getTotalFood() + value);
                case "bullets", "bullet" -> supplies.addBullets(value);
                case "axles", "axle" -> supplies.addAxles(value);
                default -> {
                    System.out.println("I'm sorry, but we don't carry " + item);
                    validItem = false;
                }
            }

            System.out.println(supplies); // supplies.toString());

        } while(validItem);

        System.out.println("Thank you! Come again!");
    }
    
}
