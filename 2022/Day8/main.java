//Micheal Callahan
//Advent Day 8 Java
//Use a grid to compare a number to its surroundings part 1. Part 2 multiply elements a number is bigger than in each direction
//19 December, 2022

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main 
{
  //Make dimension and product accesible to whole program
  static int dim = 99;
  static int product = 0;
  
  public static void main(String[] args) throws FileNotFoundException 
  {
    // Initialize variables to read
    Scanner fileInput = null;

    //Read from file
    fileInput = new Scanner(new File("text.txt"));

    //Initialize variables
    int count = (2 * dim) + (2 * (dim - 2));              //Start count on total border
    int [][] grid = new int[dim][dim];                   
    int rows = 0;
    int curr;
    boolean countUp = false;
  
    // While loop to read file
    while(fileInput.hasNext())
    {
      //Change row to a string
      String strNum = fileInput.nextLine();

      //Initalize grid
  		for (int i = 0; i < dim; i++) 
      {
  		  grid[rows][i] = Character.getNumericValue(strNum.charAt(i));
  		}

      //Next row
      rows++;
    }

    //Just look at inner grid so start row and col at 1
    for (int row = 1; row < dim - 1; row++) 
    {
  			for (int col = 1; col < dim - 1; col++) 
        {
          //Set current int
  				curr = grid[row][col];

          countUp = false;

          //Call part 2
          move2(curr,row,col,grid);

          //Part 1
          //If left element is less than curr
          if(grid[row][col - 1] < curr && countUp == false)
          { 
            countUp = move(curr,row,col - 1,0,grid);
          }
          //if right element is less than curr
          if(grid[row][col + 1] < curr && countUp == false)
          { 
            countUp = move(curr,row,col + 1,1,grid);
          }
          //If above element is less than curr
          if(grid[row - 1][col] < curr && countUp == false)
          { 
            countUp = move(curr,row - 1,col,2,grid);
          }
          //If below element is less than curr
          if(grid[row + 1][col] < curr && countUp == false)
          { 
            countUp = move(curr,row + 1,col,3,grid);
          }

          //If countUp == true then count++
          if(countUp == true)
          {
            count++;
          }
  			}
    }

    //Display results
    System.out.println("Count = " + count);
    System.out.println("Product = " + product);
  }

  //Decrement to check if bigger then rest of nums till border
  //PART 1
  public static boolean move(int curr, int row, int col, int choice, int[][] grid)
  {
    //Bool for return
    boolean status = true;
    
    //While row or col is not on border
    while(row != -1 && col != -1 && row != dim && col != dim)
    {
      //if choice = 0 then we are checking left. 1 is for right
      if(choice == 0 || choice == 1)
      {
        //If curr is bigger then keep moving left
        if(curr > grid[row][col] && choice == 0)
        {
          col--;
        }
        //If curr is bigger then keep moving right
        else if(curr > grid[row][col] && choice == 1)
        {
          col++;
        }
        else
        {
          status = false;
          break;
        }
      }
      //if choice = 2 then we are checking up. 3 is for down
      else if(choice == 2 || choice == 3)
      {
        //If curr is bigger then keep moving up
        if(curr > grid[row][col] && choice == 2)
        {         
          row--;
        }
        //If curr is bigger then keep moving right
        else if(curr > grid[row][col] && choice == 3)
        {
          row++;
        }
        else
        {
          status = false;
          break;
        }
      }
    }
    return status;
  }

  //Move for part 2
  public static void move2(int curr, int row, int col, int[][] grid)
  {
    //Bool for while loop
    boolean run = true;

    int startR = row;
    int startC = col;
    
    //Count vars
    int c1, c2, c3, c4;
    c1 = c2 = c3 = c4 = 0;
    
    //While row or col is not on border
    while(run)
    {
      //Start at the col one back to compare the left element
      col--;
      
      //If curr is bigger then keep moving left while adding 1 to count
      while(col != -1)
      {
        c1++;

        //If curr is greater than element then break
        if(grid[row][col] >= curr) {  break; }
        
        col--;
      }

      //set col to start + 1 to compare right
      col = startC + 1;
      
      //If curr is bigger then keep moving right
      while(col != dim)
      {
        c2++;

        //If curr is greater than element then break
        if(grid[row][col] >= curr) {  break; }
        
        col++;
      }

      //set col to start and row to one above
      col = startC; 
      row--;
      
      //If curr is bigger then keep moving up
      while(row != -1)
      {
        c3++;

        //If curr is greater than element then break
        if(grid[row][col] >= curr) { break; }
        
        row--;
      }

      //set row to start + 1 to compare below
      row = startR + 1;
      
      //If curr is bigger then keep moving down
      while(row != dim)
      {
        c4++;
        if(grid[row][col] >= curr) { break; }
        row++;
      } 
      
      break;
    }

    //If product is bigger than old product then replace
    if((c1 * c2 * c3 * c4) > product)
    {
      product = c1 * c2 * c3 * c4;
    }
  }
}
