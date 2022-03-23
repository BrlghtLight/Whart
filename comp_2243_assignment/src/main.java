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
        int count = 0;

        //move the inFile reference to the second line
        for (int i = 0; i < 6; i++) {
            inFile.next();
        }

        //use whileloop to read data
        while (inFile.hasNext()) {
            //read data variables here
            count++;

            //calculate


            //output the individual data
            //outFile.printf("%-12s %-15s %-8d %-6d %-6d %-6d %-8.3f %n",

        }//end while

        //output the team stats
        outFile.println();

        //ensure there is data in the file read
        if (count != 0) {
            //outFile.println();
            //outFile.printf();
        } else {
            outFile.println("No Data.");
        }
    }
}