#Design pattern implementation file
#board class created in this file to factor the code. 
import pygame
import sys
from pygame.locals import *

from constants import *


#Creating Board Class that will be used by gameTestFile.py
class Board():
    # encapsulate board variable
    board =[BLANK] * 9 ;


    def __init__(self, i_var):
        self.i_var = i_var
