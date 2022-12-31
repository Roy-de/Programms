import random
import numpy as np

def display(room):
    print(room)

room = np.array([[1,1,1,1,1,1],[1,1,1,1,1,1],[1,1,1,1,1,1],],dtype=np.int32)

print("all rooms are dirty")
display(room)
x = 0
y = 0
def before_cleaning(x,y):
    while x < 3:
        while y < 6:
            room[x][y] = random.choice([0,1])
            y += 1
        x += 1
        y = 0

def vacuum():
    x = 0
    y = 0
    z = 0  
    while x < 3:
        while y < 6:
            if room[x][y] == 1:
                print("Vacuum in this location now",x,y)
                room[x][y] = 0
                print("Cleaned",x,y) 
                z += 1
            y += 1
        x += 1
        y = 0                   
    pro = (100 - ((z/16)*100))
    display(room)
    print("performance= ",pro," %")


if __name__ == '__main__':
  before_cleaning(x,y)
  print("before cleaning the room I detect all of the random dirt")
  display(room)
  vacuum()