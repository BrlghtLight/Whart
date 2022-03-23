/*
     Author:
     Date:
     Program:
     Description:
*/

import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String inputFile;

        //create read file
        System.out.print("Input file name: ");
        inputFile = console.nextLine();
        Scanner inFile = createFileInputObject(inputFile);

        //create result file
        System.out.print("Output file name: ");
        inputFile = console.nextLine();
        PrintWriter outFile = createFileOutputObject(inputFile, false);

        //Calculate
        fileIOMethod(inFile, outFile);

        //close read and written files
        inFile.close();
        outFile.close(); //must

        //success
        System.out.println("0");

    }


    ////
    //
    //Create input file object
    //
    ////
    public static Scanner createFileInputObject(String fileName) throws IOException {
        File myFile = new File(fileName);
        Scanner inFile = new Scanner(myFile);

        return inFile;
    }

    ////
    //
    //Create output file object
    //
    ////
    public static PrintWriter createFileOutputObject(String fileName, boolean flag) throws IOException {
        FileWriter fw = new FileWriter(fileName, flag);
        PrintWriter outFile = new PrintWriter(fw);

        return outFile;
    }

    ////
    //
    //Read, calculate, write
    //
    ////
    public static void fileIOMethod(Scanner inFile, PrintWriter outFile) throws IOException {
        String name, team, position;
        double fgm = 0, fga = 0, reb, ast, fgp;
        int count = 0,
                cCount = 0,
                pfCount = 0,
                sfCount = 0,
                sgCount = 0,
                pgCount = 0;

        //move the inFile reference to the second line
        for (int i = 0; i < 7; i++) {
            inFile.next();
        }

        //read
        while (inFile.hasNext()) {
            name = inFile.next();
            team = inFile.next();
            position = inFile.next();
            fgm = inFile.nextDouble();
            fga = inFile.nextDouble();
            reb = inFile.nextDouble();
            ast = inFile.nextDouble();
            count++;

            //calculate field goal percentage fgp = FGM/FGA
            fgp = fgm / fga;

            //calculate players in certain positions
            if (position.equals("C")) {
                cCount++;
            }
            if (position.equals("PF")) {
                pfCount++;
            }
            if (position.equals("SF")) {
                sfCount++;
            }
            if (position.equals("SG")) {
                sgCount++;
            }
            if (position.equals("PG")) {
                pgCount++;
            }

            //output the individual data
            outFile.printf("%-10s %-15s %-15s %-5d %-5d %-5d %-5d %-8.2f %n",
                    name, team, position, fgm, fga, reb, ast, fgp);

        }//while

        //output stats
        outFile.println();

        if (count != 0) {
            outFile.println("Total Players: " + count);
            outFile.println("Total Centers: " + cCount);
            outFile.println("Total Power Forwards: " + pfCount);
            outFile.println("Total Small Forwards: " + sfCount);
            outFile.println("Total Shooting Guards: " + sgCount);
            outFile.println("Total Point Guards: " + pgCount);
            outFile.printf("Field Goal Percentage: %.2f %n", fgm / fga);
        } else {
            outFile.println("No Data.");
        }
    }
}