import random
from matplotlib import pyplot, colors
#Class , defining agents as abstract datatypes
class agent:
    #init method, the constructor
     def __init__(self,x,y,group):
        self.life = 100.0 #Agents score
        self.x = x
        self.y = y
        self.group = group

#creating empty 100 x 100 list
battlefield  = [[None for i in range(0,100)]for i in range(0,100)]
#Creating 100 agents for group a nd b
locations = battlefield.copy()

agents_a = []
agents_b = []

def agentCreator(size,group,groupList,field,n,m):
    for j in range(0,size):
        #select random available location
        while True:
            x = random.choice(range(0,n))
            y = random.choice(range(0,m))
            #check idf spot is available
            if field[x][y] == None:
                field[x][y] = agent(x = x,y = y,group = group)
                groupList.append(field[x][y])
                break
            
agentCreator(size = 1000,group = "A",groupList = agents_a,field = battlefield,n = 100,m = 100)
agentCreator(size = 1000,group = "B",groupList = agents_b,field = battlefield,n = 100,m = 100)



#Visualize
#Not part of my code though
# .imshow() needs a matrix with float elements;
population = [[0.0 for i in range(0,100)] for i in range(0,100)]
# if agent is of type A, put a 1.0, if of type B, pyt a 2.0
for i in range(1,100):
    for j in range(1,100):
        if battlefield[i][j] == None: # empty
            pass # leave 0.0 in population cell
        elif battlefield[i][j].group == "A": # group A agents
            population[i][j] = 1.0 # 1.0 means "A"
        else: # group B agents
            population[i][j] = 2.0 # 2.0 means "B"
# import pyplot and colors from matplotlib

# using colors from matplotlib, define a color map
colormap = colors.ListedColormap(["lightgrey","green","blue"])
# define figure size using pyplot
pyplot.figure(figsize = (12,12))
# using pyplot add a title
pyplot.title("battlefield before simulation run (green = A, blue = B)",
            fontsize = 24)
# using pyplot add x and y labels
pyplot.xlabel("x coordinates", fontsize = 20)
pyplot.ylabel("y coordinates", fontsize = 20)
# adjust x and y axis ticks, using pyplot
pyplot.xticks(fontsize = 16)
pyplot.yticks(fontsize = 16)
# use .imshow() method from pyplot to visualize agent locations
pyplot.imshow(X = population,
             cmap = colormap)             