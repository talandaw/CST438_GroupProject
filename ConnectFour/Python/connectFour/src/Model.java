/*
 *Courtney Dunbar
 * Connect Four
 * Model View Controller Design Pattern
 * ClassName: Model.java
 * 
 * 2 player game. One player receives red pieces. The other player receives black pieces.
 * The winner gets four of their pieces in a row either horizontally, vertically, or diagonally.
 * 
 */

import java.awt.Point;

public class Model implements ModelInterface 
{
   char[][] board = new char[4][4];
   View view;
   char player = 'r';

   public Model(View view){
      this.view = view;
      reset();
   }

   private void reset() 
   {
	   //when game finishes, resets to blank
      for(int i = 0; i < 4; i++){
         for(int j = 0; j < 4; j++){
            board[i][j] = 0;
         }
      }
   }

   private void takeTurn(char player, Point position)
   {
      board[position.x][position.y] = player;
      view.playerMove(position.y+4*position.x, player);
      win();
      checkTie();
      nextPlayer();
   }

   private void win()
   {
	   //checks for horizontal, vertical, and diagonal wins
	   //horizontal
	  if(board [3][0]!=0 && board[3][0] == board[3][1] && board[3][0]== board[3][2] &&
			  board[3][0] == board[3][3]){
		  winner(board[3][3]);
	  }
	  if(board [2][0]!=0 && board[2][0] == board[2][1] && board[2][1]== board[2][2] &&
			  board[2][2] == board[2][3]){
		  winner(board[2][3]);	
	  }
	  
	  if(board [1][0]!=0 && board[1][0] == board[1][1] && board[1][1]== board[1][2] &&
			  board[1][2] == board[1][3]){
		  winner(board[1][3]);	
	  }
	  
	  if(board [0][0]!=0 && board[0][0] == board[0][1] && board[0][1]== board[0][2] &&
			  board[0][2] == board[0][3]){
		  winner(board[0][3]);
	  }
	  
	  //vertical
	  if(board [3][0]!=0 && board[3][0] == board[2][0] && board[2][0]== board[1][0] &&
			  board[1][0] == board[0][0]){
		  winner(board[0][0]);
	  }
	  
	  if(board [3][1]!=0 && board[3][1] == board[2][1] && board[2][1]== board[1][1] &&
			  board[1][1] == board[0][1]){
		  winner(board[0][1]);
	  }
	  
	  if(board [3][2]!=0 && board[3][2] == board[2][2] && board[2][2]== board[1][2] &&
			  board[1][2] == board[0][2]){
		  winner(board[0][2]);
	  }
	  
	  if(board [3][3]!=0 && board[3][3] == board[2][3] && board[2][3]== board[1][3] &&
			  board[1][3] == board[0][3]){
		  winner(board[0][2]);
	  }
	  
	  //diagonal
	  if(board [3][0]!=0 && board[3][0] == board[2][1] && board[2][1]== board[1][2] &&
			  board[1][2] == board[0][3]){
		  winner(board[0][3]);
	  }
	  if(board [3][3]!=0 && board[3][3] == board[2][2] && board[2][2]== board[1][1] &&
			  board[1][1] == board[0][0]){
		  winner(board[0][0]);
	  }
   }

   private void winner(char winner)
   {
      view.gameWon(player);
      reset();
   }

   private void checkTie()
   {
	   int i=0;
	   int j=0;
	   
	   while(i<5 &&j<5){
            if(board[i][j] == 0){
               return;         
         }
            i++;
            j++;
   }
      
      view.gameTie();
      reset();
   }

   private void nextPlayer()
   {
      if(this.player == 'r')
      {
         this.player = 'b';
      }
      else
         this.player = 'r';          
   }
   
   @Override
   public void movePlayer(Point location) 
   {
	  location.x=3;
      while(board[location.x][location.y]!=0){
    	  location.x=location.x-1;
      }
      takeTurn(player, location); 
   }
}

