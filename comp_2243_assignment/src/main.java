/*
     Author:
     Date:
     Program:
     Description:
*/

import java.util.*;
import java.io.*;

public class comp_2243_assignment {
    public static void main(String [] args) throws IOException {
        Scanner console = new Scanner(System.in);

        String fileName;

        System.out.print("Enter input file name: ");
        fileName = console.nextLine();

        //call the method to create the file input object
        Scanner inFile = createFileInputObject( fileName );

        System.out.print("Enter output file name: ");
        fileName = console.nextLine();

        //call the method to create the file output object
        PrintWriter outFile = createFileOutputObject( fileName, false );

        //call the method to read and write
        fileIOMethod( inFile, outFile );

        //close the file input and outputobjects
        inFile.close();
        outFile.close(); //must

        System.out.println("The program is done.");

    }//end main

    //method definition - create the input file object
    public static Scanner createFileInputObject( String fileName ) throws IOException
    {
        File myFile = new File(fileName);
        Scanner inFile = new Scanner( myFile );

        return inFile;
    }

    //method definition = creation of the output file object
    public static PrintWriter createFileOutputObject( String fileName, boolean flag ) throws IOException
    {
        FileWriter fw = new FileWriter(fileName, flag);
        PrintWriter outFile = new PrintWriter(fw);

        return outFile;
    }

    //method definition - read data and calculate stats and write the results to the output file
    public static void  fileIOMethod( Scanner inFile, PrintWriter outFile ) throws IOException
    {


        //move the inFile reference to the second line
        for( int i = 0; i<6; i++ )
        {
            inFile.next();
        }

        //use whileloop to read data
        while(inFile.hasNext())
        {
            //read data variables here
            count++;

            //calculate


            //output the individual data
            //outFile.printf("%-12s %-15s %-8d %-6d %-6d %-6d %-8.3f %n",

        }//end while

        //output the team stats
        outFile.println();

        //ensure there is data in the file read
        if(count != 0)
        {
            //outFile.println();
            //outFile.printf();
        }
        else
        {
            outFile.println("No Data.");
        }
    }
}