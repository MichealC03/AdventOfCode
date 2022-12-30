//Micheal Callahan
//Day 1
//Find the largest amount of sums from a text file
//2 December, 2022

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) 
  {
    //Make a max and sum variable
    int maxOne = 0;
    int maxTwo = 0;
    int maxThree = 0;
    int sum = 0;
    String temp = "";

    //Read from the text file
    // Initialize variables to read
    Scanner fileInput = null;
    
    // Try catch to populate the array
    try
      {
        fileInput = new Scanner(new File("text.txt"));
      }
      
    // Catch an error
    catch(FileNotFoundException e)
      {
        e.printStackTrace();
      }

    // While loop to read file
    while(fileInput.hasNext())
      {
        //Set temp  = to the next Line in file
        temp = fileInput.nextLine();

        //If temp is not a blank space than add temp to sum
        if(temp != "")
        {
          sum += Integer.valueOf(temp);
        }
        //If it is then see if sum is greater than any of the 3 maxes
        else
        {
          //If sum is greater than max one
          if(sum > maxOne)
          {
            //Pass maxes down the list
            maxTwo = maxOne;
            maxThree = maxTwo;

            //Make max = to the bigger number
            maxOne = sum;
          }
          //If sum is greater than max two
          else if(sum > maxTwo)
          {
            //Pass maxes down the list
            maxThree = maxTwo;

            //Make max = to the bigger number
            maxTwo = sum;
          }
          //If sum is greater than max three
          else if(sum > maxThree)
          {
            maxThree = sum;
          }

          //Reset sum for while loop
          sum = 0;
        }
      }

    //Close file
    fileInput.close();

    //Print out results
    System.out.println("The first elf has " + maxOne);
    System.out.println("The second elf has " + maxTwo);
    System.out.println("The third elf has " + maxThree);
    System.out.println("The elves combined have " + (maxOne + maxTwo + maxThree));
  }
}
