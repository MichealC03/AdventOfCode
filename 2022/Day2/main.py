#Micheal Callahan
#Python Challenge Day 2
#Take a txt file. Take the letters and decide how to beat opponent in rock paper scissors
#December 3, 2022

# Make variables for elf and user. Also score var
elfVal = 0
userVal = 0
score = 0

# Scores assigned to objects
rock = 1
paper = 2
scissors = 3

#Open file
with open('text.txt') as f:

  #While there is a next line in txt file
  while True:
    line = f.readline()

    #If not line then break out
    if not line:
        break

    #Print the line
    lines = line.strip()

    #If rock then assign val 1
    if lines[0] == 'A':
      elfVal = 1
    if lines[2] == 'X':
      userVal = 1

    #If paper then assign val 2
    if lines[0] == 'B':
      elfVal = 2
    if lines[2] == 'Y':
      userVal = 2

    #If scissors then assign val 3
    if lines[0] == 'C':
      elfVal = 3
    if lines[2] == 'Z':
      userVal = 3

    #ROCK
    if elfVal == 1:
      #WIN paper
      if userVal == 3:
        score += paper + 6
      #TIE rock
      elif userVal == 2:
        score += rock + 3
      #LOSS scissors
      elif userVal == 1:
        score += scissors
    #PAPER
    elif elfVal == 2:
      #WIN scissors
      if userVal == 3:
        score += scissors + 6
      #TIE paper
      elif userVal == 2:
        score += paper + 3
      #LOSS rock
      elif userVal == 1:
        score += rock
    #SCISSORS
    elif elfVal == 3:
      #WIN rock
      if userVal == 3:
        score += rock + 6
      #TIE scissors
      elif userVal == 2:
        score += scissors + 3
      #LOSS paper
      elif userVal == 1:
        score += paper

#Print
print("Total score is:", score)
