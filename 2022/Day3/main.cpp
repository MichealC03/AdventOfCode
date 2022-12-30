//Micheal Callahan
//Advent 2 C++
//Read txt file then find similarites between halves of string (Part 1)
//Read three lines from txt file and find similarities (Part 2)
//4 December, 2022

#include <iostream>
#include <fstream>
#include <string.h>
using namespace std;

int main() 
{
  //Open text file
  ifstream myFile("text.txt");

  //Variables for the file
  string line, firstHalf, nextHalf, match2;
  int match = 0;
  int sum = 0;
  int count = 1;

  //Part 2 variables
  string first,second,third;
  string ans = "";

  //While loop for reading the file
  while(getline(myFile, line))
  {
    //Split the string (Part 1)
    //firstHalf = line.substr(0, line.size() / 2);
    //nextHalf = line.substr(line.size() / 2);

    //if count = 1
    if(count == 1)
    {
      first = line;
      count++;
    }
    //If count = 2
    else if(count == 2)
    {
      second = line;
      count++;
    }
    //Else count = 3
    else
    {
      third = line;
      
      //For loop to find which char is similar
      for(int i = 0; i < first.size(); i++)
      {  
        //Inner loop to go thru each character in secondHalf
        for(int j = 0; j < second.size(); j++)
        {
          //If match
          if(first[i] == second[j])
          {
            ans += second[j];
          }
        }
      }

      //Compare ans to third str
      for(int i = 0; i < ans.size(); i++)
      {
        //Inner loop to go thru each character in third
        for(int j = 0; j < third.size(); j++)
        {
          //If match
          if(ans[i] == third[j])
          {
            match = third[j];
            break;
          }
        }
      }
 
      //If match lowercase then subtract 96
      if(match > 96)
      {
        sum += match - 96;
      }
      //If uppercase start at 27 (after the lowercase)
      else
      {
        sum += (match - 64) + 26;
      }

      count = 1;
    }
  }

  cout << sum << endl;
}
