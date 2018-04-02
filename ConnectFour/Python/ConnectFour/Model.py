import os
import random
import time
from abc import ABCMeta, abstractmethod
import array

import Point

class Model: 
   w, h = 4, 4;
   board = [[0 for x in range(w)] for y in range(h)] 
   view = View()
   player = 'r'

   def Model(view):
      this.view = view
      reset()

   def reset(self): 
	   #//when game finishes, resets to blank
       for i in [0,3]:   
         for j in [0,3]:
            board[i][j] = 0
       
   def takeTurn(player, position):
      board[position.x][position.y] = player
      view.playerMove(position.y + 4 * position.x, player)
      win()
      checkTie()
      nextPlayer()

   def winnerFound(winner):
      view.gameWon(player)
      reset()

   def win(self):
	   #//checks for horizontal, vertical, and diagonal wins
	   #//horizontal
      if board[3][0] != 0 and board[3][0] == board[3][1] and board[3][0] == board[3][2] and board[3][0] == board[3][3]:		  
          winnerFound(board[3][3])	  

      if board[2][0] != 0 and board[2][0] == board[2][1] and board[2][1] == board[2][2] and board[2][2] == board[2][3]:
	      winnerFound(board[2][3])		
      
      if board[1][0] != 0 and board[1][0] == board[1][1] and board[1][1] == board[1][2] and board[1][2] == board[1][3]:
		  winnerFound(board[1][3])	 
      
      if board[0][0] != 0 and board[0][0] == board[0][1] and board[0][1] == board[0][2] and board[0][2] == board[0][3]:
		  winnerFound(board[0][3])
	  	  
	  #//vertical
      if board[3][0] != 0 and board[3][0] == board[2][0] and board[2][0] == board[1][0] and board[1][0] == board[0][0]:
		  winnerFound(board[0][0])
	  
      if board[3][1] != 0 and board[3][1] == board[2][1] and board[2][1] == board[1][1] and board[1][1] == board[0][1]:
		  winnerFound(board[0][1])

      if board[3][2] != 0 and board[3][2] == board[2][2] and board[2][2] == board[1][2] and board[1][2] == board[0][2]:
		  winnerFound(board[0][2])

      if board[3][2] != 0 and board[3][2] == board[2][2] and board[2][2] == board[1][2] and board[1][2] == board[0][2]:
		  winnerFound(board[0][2])

      if board[3][3] != 0 and board[3][3] == board[2][3] and board[2][3] == board[1][3] and board[1][3] == board[0][3]:
		  winnerFound(board[0][2])

      #//diagonal
	  
      if board[3][0] != 0 and board[3][0] == board[2][1] and board[2][1] == board[1][2] and board[1][2] == board[0][3]:
          winnerFound(board[0][3])
      
      if board[3][3] != 0 and board[3][3] == board[2][2] and board[2][2] == board[1][1] and board[1][1] == board[0][0]:
          winnerFound(board[0][0])

   def winnerFound(winner):
      view.gameWon(player)
      reset()

   def checkTie(self):
      #if game is tied reset
      for i in [0,3]:  
          for j in [0,3]:                  
              if board[i][j] == 0:                   
                  view.gameTie()
                  reset()

   def nextPlayer(self):
      if player == 'r':
        player = 'b'
      else:
        reset()    
  
   @Override
   def movePlayer(Point): 
      location =Point
      x=3
      player = 'b' 
      location.x=location.x-1
      player = 'r'        