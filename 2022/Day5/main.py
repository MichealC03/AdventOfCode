#Micheal Callahan
#Advent Day 5
#Use a queue to move elements from stacks (FIFO). Part 2, any quantity more than 1 moves in same order
#5 Decemeber, 2022

#Initialize arrays
arr1 = ["N", "S", "D", "C", "V", "Q", "T"]
arr2 = ["M", "F", "V"]
arr3 = ["F", "Q", "W", "D", "P", "N", "H", "M"]
arr4 = ["D", "Q", "R", "T", "F"]
arr5 = ["R", "F", "M", "N", "Q", "H", "V", "B"]
arr6 = ["C", "F", "G", "N", "P", "W", "Q"]
arr7 = ["W", "F", "R", "L", "C", "T"]
arr8 = ["T", "Z", "N", "S"]
arr9 = ["M", "S", "D", "J", "R", "Q", "H", "N"]

#Find the array to be used
def choose(num):
  if(num == 1):
    return arr1
  elif(num == 2):
    return arr2
  elif(num == 3):
    return arr3
  elif(num == 4):
    return arr4
  elif(num == 5):
    return arr5
  elif(num == 6):
    return arr6
  elif(num == 7):
    return arr7
  elif(num == 8):
    return arr8
  elif(num == 9):
    return arr9

#Display
def display():
  print(arr1)
  print(arr2)
  print(arr3)
  print(arr4)
  print(arr5)
  print(arr6)
  print(arr7)
  print(arr8)
  print(arr9)

#read from file
with open('text.txt') as f:

  #Read lines till no more
  while True:

    line = f.readline()
    
    if not line:
      break

    #Get the string of lines
    lines = line.strip()
    
    #Variables for moving crates
    quantity = 0
    fromArr = 0
    fArr = []
    toArr = 0
    tArr = []

    #Get the quantity integer
    quantity = int(lines[lines.find("e") + 1 : lines.find(" from")])
    
    #Get the num of arr to move from
    fromArr = int(lines[lines.find("from") + 4 : lines.find(" to")])

    #Get the num of arr to move toArr
    toArr = int(lines[lines.find("to") + 2 : ])

    #Find which arrays are going to be used
    fArr = choose(fromArr)
    tArr = choose(toArr)

    #Move the quantity from each arr (if quantity is 1)
    if(quantity == 1):
      for x in range(quantity):
        
        #Remove from fromArr
        removed = fArr.pop()
  
        #Add to the toArr
        tArr.append(removed)
    #else keep in same order
    else:
      #Order arr to add to here first to maintain order
      orderArr = []

      #Add elements to orderArr
      for x in range(quantity):
        
        #Remove from fromArr
        removed = fArr.pop()
  
        #Add to the toArr
        orderArr.append(removed)

      #Take out of orderArr which will reverse order in orderArr
      for x in range(quantity):
        
        #Remove from fromArr
        removed = orderArr.pop()
  
        #Add to the toArr
        tArr.append(removed)
        
#Print
display()
