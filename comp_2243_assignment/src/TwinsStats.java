/*
     Author: Marcus Walbridge
     Date:
     Program: TwinsStats.java
     Description: 
*/

import java.util.Scanner;
import java.io.*;

public class TwinsStats
{
   public static void main(String [] args) throws IOException
   
   {
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
      PrintWriter outFile = new PrintWriter( fw );
       
      return outFile;
   }
   
   //method definition - read data and calculate stats and write the results to the output file
   public static void  fileIOMethod( Scanner inFile, PrintWriter outFile ) throws IOException
   {
      String firstName, lastName;
      int gamesPlayed, atBat, hit, run;
      int sumAtBat = 0, sumHit = 0, sumRun = 0;
      int count = 0;
      double battingAverage, teamAverage;
      
      //move the inFile reference to the second line
      for( int i = 0; i<6; i++ )
      {
         inFile.next();
      }
      
      //use whileloop to read data 
      while(inFile.hasNext())
      {
         firstName = inFile.next();
         lastName = inFile.next();
         gamesPlayed = inFile.nextInt();
         atBat = inFile.nextInt();
         run = inFile.nextInt();
         hit = inFile.nextInt();
          
         count++;
          
          //Batting Average
         if(atBat != 0)
         {
            battingAverage = (double)hit / atBat; //individuals
         }
         else
         {
            battingAverage = 0.0;
         }
          
          //calculate sum
         sumAtBat += atBat;
         sumHit += hit;
         sumRun += run;
          
          //output the individual data
         outFile.printf("%-12s %-15s %-8d %-6d %-6d %-6d %-8.3f %n",
                         firstName, lastName, gamesPlayed,
                         atBat, run, hit, battingAverage);
        
      }//end while
      
      //output the team stats
      outFile.println();
      
      if(count != 0)
      {
         outFile.println("Total Number of Players: " + count);
         outFile.printf("Team Total Hits: %,d %n", sumHit);
         outFile.printf("Team total Runs: %,d %n", sumRun);
         outFile.printf("Team Batting Average: %.2f %n", sumHit / (double)sumAtBat);
      }      
      else
      {
         outFile.println("No Data.");
      }
   }
}