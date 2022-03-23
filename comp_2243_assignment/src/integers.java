/*
     Author:
     Date:
     Program:
     Description:
*/

import java.util.*;

public class integers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int posInt;
        int count = 0, factorCount = 0;
        double factorAverage = 0;

        System.out.print("Enter Positive Integer: ");
        posInt = console.nextInt();

        System.out.println("Factors are: ");
        for (int i = 1; i <= posInt; i++) {
            if (posInt % i == 0) {
                System.out.print(i + " ");
                factorAverage += i;
                count++;
            }
        }
        System.out.printf("%nAverage of Factors: %.2f", (factorAverage / count));
        System.out.println("\nNumber of Factors: " + count);

        //reset
        count = 0;
        factorAverage = 0;

        System.out.println("\nNon Factors are: ");
        for (int i = 1; i <= posInt; i++) {
            if (posInt % i >= 1) {
                System.out.print(i + " ");
                factorAverage += i;
                count++;
            }
        }
        System.out.printf("%nAverage of Non Factors: %.2f", (factorAverage / count));
        System.out.println("\nNumber of Non Factors: " + count);


        //reset
        count = posInt;
        factorAverage = 0;
        System.out.println("\nFactors Reverse Order");

        do {
            if (posInt % count == 0) {
                System.out.print(count + " ");
                factorCount++;
                factorAverage += count;
            }
            count--;
        } while (count >= 1);

        System.out.println("\n\nFactor Count: " + factorCount);
        System.out.printf("Factor Average: %.2f", (factorAverage / factorCount));
        System.out.println("\n\n\n0");
    }//main
}//class
