package edu.soravic.Assign04;
import java.util.Scanner;

public class PrintShop {
    public static BusinessCard askForBusinessCardData(Scanner input)
    {
        String name = "";
        String[] sloganLines = {"", "", "", ""};
        char bound; 
        System.out.println("Enter business name:");
        name = input.nextLine();
        System.out.println("Enter boundary character:");
        bound = input.nextLine().charAt(0);

        System.out.println("Enter slogan (max 4 lines):");
        int i;
        for(i = 0; i < 4; i++)
            sloganLines[i] = input.nextLine();

        BusinessCard b = new BusinessCard(name, sloganLines, bound);
        return b;
    }


    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        BusinessCard b = askForBusinessCardData(input);
        System.out.println("Your new business card:");
        System.out.println(b);
    }
}
