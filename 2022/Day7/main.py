#Micheal Callahan and got some help from Jonathan Paulson on youtube
#Day 7 Python Advent
#Find sum of all files under 100 thousand in size. Part 2 delete the min num over the free space
#December 15,2022

from collections import defaultdict

#Put the lines in an arr
data = open("text.txt").read().strip()
lines = [x for x in data.split('\n')]

#dict and values for storing values
DICT = defaultdict(int)
vals = []
sum = 0

#Go thru each element
for line in lines:
  #Seperate each element from above into its each seperate arr
  sep = line.strip().split()

  if sep[1] == 'cd':
    #Pop if .. is 2 because go out one level, append if not because moving in a level
    if sep[2] == '..':
      vals.pop()
    else:
      vals.append(sep[2])
      
  elif sep[1] == 'ls':
    continue
  elif sep[0] == 'dir':
    continue
  #Else then it is a number
  else:
    dict = int(sep[0])

    #This seperates the files as it joins a '/' w/ the names appended earlier
    #dict is then added at the end as it is the total that is found in the directory
    for i in range(len(vals) + 1):
      DICT['/'.join(vals[:i])] += dict

#PART 2 instructions
#The total disk space available to the filesystem is 70000000. To run the update, you need unused space of at least 30000000. You need to find a directory you can delete that will free up enough space to run the update.

available = 70000000 - 30000000
occupied = DICT['/']
free = occupied - available

#Set delete to a high num to replace it when j runs thru
delete = 1e9
      
#For loop to find sum
#i is the directory and j is the sum
for i, j in DICT.items():
  print(j)
  #If j is gt or eq to free AND lt or eq to delete then make delete eq to j
  if j >= free and j <= delete:
    delete = j
    
  #Find the sum for anything less than 10 MB
  if j <= 100000:
    sum += j

print("\nPart 1", sum)
print("\nPart 2", delete)
