//Micheal Callahan
//Advent Day 5 Java
//Find when the last four chars in first str are different. Part 2 is looking for 14
//6 December, 2022

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main 
{
  //Distinct chars looking for
  static int bounds = 14;
  
  public static void main(String[] args) 
  {
    // Initialize variables to read
    Scanner fileInput = null;

    //Initialize variables to solve problem
    String str = "";
    boolean cont = false;
    boolean match = false;
    
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
        //Pass text into first string
        str = fileInput.next();
      }

    //Make str to char array to seperate chars
    char[] arr = str.toCharArray();

    //Set first = 0 which will be the first element
    int first, next;
    first = next  = 0;
    int max1, max2;
      
    //While loop that runs while cont is false
    while(!cont)
    {
      //Set next = to first + 1
      next = first + 1;

      //Set bounds for for loop so no out of bounds
      //Max1 is set to look at the 3 elements after first
      //Max2 is for the inner loop to look at the elements after first
      max1 = first + (bounds - 1);
      max2 = next + (bounds - 2);
       
      //For loop to see if any 4 chars are the same
      for(int i = first; i <= max1; i++)
      {
        //if match = true then break
        if(match == true) {break;}
        
        //Inner loop to check the next element after i
        for(int j = i + 1; j <= max2; j++)
        {
          //If arr[i] == an arr[j] then set match to true and break from this loop
          if(arr[i] == arr[j])
          {
            match = true;
            break;
          }
        }
      }

      //If there is a match then set to false and examine next element
      if(match)
      {
        match = false;
        first++;
      }
      //Else then four unique have been found
      else
      {
        break;
      }
    }

    //Add the amount to first of distinct chars looked for
    System.out.println(first + bounds);

    fileInput.close();
  }
}
