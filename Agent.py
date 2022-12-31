from abc import abstractmethod, abstractstaticmethod
from utils import *
import random
import copy

class Object:
    #Functions
    def __repr__(self):
        return '<%s>'%getattr(self,'__name__',self.__class__.__name__)

    def is_alive(self):
        return hasattr(self,'alive') and self.is_alive

    def display(self,canvas,x,y,width,height):
        pass 

class Agent(Object):
    def __init__(self):  
      def program(percept):
           return input('Percept = %s; action'%percept)
      self.program = program
      self.alive = True 

    def TraceAgent(agent):
        old_program = agent.program
        def new_program(percept):
            action = old_program(percept) 
            print('%s perceives %s and does %s'%(agent,percept,action))
            return action
        agent.program = new_program
        return agent
class TableDrivenAgent(Agent):
    def __init__(self,table):
        Agent.__init__(self) 
        percepts = []
        def program(percept):
            percepts.append(percept)
            action = table.get(tuple(percepts))
            return action
        self.program = program 

class RandomAgent(Agent):
    def __init__(self,actions):
        Agent.__init__(self)
        self.program =  lambda percept: random.choice(actions) 

        
loc_A, loc_B = (0,0),(1,0)# The two locations for the vacuum world 

class ReflexVacuumAgent(Agent):

            def __init__(self):
                Agent.__init__(self)
                def program(location,status):
                   if status == 'Dirty':return 'Suck'
                   elif location == loc_A: return 'Right'
                   elif location == loc_B: return 'left'
                self.program = program

            def RandomVacuumAgent():
                return RandomAgent(['Right','left','Suck','No Op'])

            def TableDrivenVacuumAgent():
                table = {((loc_A,'Clean'),):'Right',
                         ((loc_A,'Dirty'),):'Suck',
                         ((loc_B,'Clean'),):'left',
                         ((loc_B,'Dirty'),):'Suck',
                         ((loc_A, 'Clean'), (loc_A, 'Clean')): 'Right',
                         ((loc_A, 'Clean'), (loc_A, 'Dirty')): 'Suck',
                         ((loc_A, 'Clean'), (loc_B, 'Clean')): 'Right',
                         ((loc_A, 'Clean'), (loc_B, 'Dirty')): 'Suck',
                         ((loc_B, 'Clean'), (loc_A, 'Clean')): 'Right',
                         ((loc_B, 'Clean'), (loc_A, 'Dirty')): 'Suck',
                         }        
                return TableDrivenAgent(table)

class ModelBasedVacuumAgent:
    def __init__(self):
        self.objects = []; self.agents = []
    object_classes = []

    def percept(self,agent):
        abstractmethod
#Change the world to reflect this action .Override this
    def execute_action(self,agent,action):
        abstractmethod
#Default location to place a new object
    def default_location(self,object):
        return None 
    #If there is spontaneous change, override this    
    def exogenous_change(self):
        pass

    def is_done(self):
        #By default we are done when we can't find a live agent
        for agent in self.agents:
            if agent.is_alive():
                return False
            return True    