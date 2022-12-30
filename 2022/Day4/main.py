#Micheal Callahan
#Python Challenge Day 4
#Take a txt file. See if number lists contain one another
#December 5, 2022

#Initialize count for counting pairs contained
count = 0

#Open file
with open('text.txt') as f:

  #While there is a next line continue reading
  while True:

    line = f.readline()

    #If no line then jump out of while loop
    if not line:
      break

    #Get the line into a string
    str = line.strip()

    #Get nums first pair
    firstNum = str[0 : str.find("-")]
    secondNum = str[str.find("-") + 1 : str.find(",")]

    #Split str in 2
    splitStr = str[str.find(",") :]

    #Second pair
    thirdNum = splitStr[splitStr.find(",") + 1 : splitStr.find("-")]
    fourthNum = splitStr[splitStr.find("-") + 1 :]

    #Change to ints
    firstNum = int(firstNum)
    secondNum = int(secondNum)
    thirdNum = int(thirdNum)
    fourthNum = int(fourthNum)
    
    #If firstNum contained
    if(firstNum >= thirdNum and firstNum <= fourthNum):
      count += 1
    #if secondNum contained
    elif(secondNum >= thirdNum and secondNum <= fourthNum):
      count += 1
    #if thirdNum contained
    elif(firstNum <= thirdNum and thirdNum <= secondNum):
      count += 1
    #if fourth contained
    elif(firstNum <= fourthNum and fourthNum <= secondNum):
      count += 1

print(count)
