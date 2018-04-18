#Design pattern implementation file
#create separate file for constants
import pygame
import sys
from pygame.locals import *

# Create the constants (go ahead and experiment with different values)
BOARDWIDTH = 3  # number of columns in the board
BOARDHEIGHT = 3  # number of rows in the board
TILESIZE = 100
WINDOWWIDTH = 480
WINDOWHEIGHT = 480
FPS = 30
#                 R    G    B
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
BRIGHTBLUE = (0, 50, 255)
DARKTURQUOISE = (3, 54, 73)
GREEN = (0, 204, 0)

BGCOLOR = DARKTURQUOISE
TILECOLOR = GREEN
TEXTCOLOR = WHITE
BORDERCOLOR = BRIGHTBLUE
BASICFONTSIZE = 20

BUTTONCOLOR = WHITE
BUTTONTEXTCOLOR = BLACK
MESSAGECOLOR = WHITE

BLANK = 10
PLAYER_O = 11
PLAYER_X = 21

PLAYER_O_WIN = PLAYER_O * 3
PLAYER_X_WIN = PLAYER_X * 3


CONT_GAME = 10
DRAW_GAME = 20
QUIT_GAME = 30

XMARGIN = int((WINDOWWIDTH - (TILESIZE * BOARDWIDTH + (BOARDWIDTH - 1))) / 2)
YMARGIN = int((WINDOWHEIGHT - (TILESIZE * BOARDHEIGHT + (BOARDHEIGHT - 1))) / 2)

choice = 0
