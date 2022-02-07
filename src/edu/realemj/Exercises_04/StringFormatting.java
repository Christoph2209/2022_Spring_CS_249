package edu.realemj.Exercises_04;
import java.util.*;

public class StringFormatting {
    public static void main(String [] args) {
        System.out.printf("Number: %05d\n", 356);
        // Prints 00356
        System.out.printf("Success: %.1f%%\n", 89.16);

        System.out.printf("%06.2f\n", 2.5);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter name and age:");
        String name = input.next();
        int age = input.nextInt();

        String s = String.format("My name is %s, and I am %d years old.", name, age);
        System.out.println("The user said: \"" + s + "\".");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++) {
            sb.append(i);
            sb.append(", ");
        }
        String out = sb.toString();
        System.out.println(out);

        String name_and_address = """
                        Barney Fife
                          105 Roger Lane
                          Mayberry, GA    10203
                        """;
        System.out.println(name_and_address);


    }    
}
