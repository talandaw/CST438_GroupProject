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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class View extends JFrame implements MouseListener, ViewInterface 
{
	//initiate board for Connect Four game 
	ArrayList<JLabel> board = new ArrayList<JLabel>();
	
	   //initiate rows and columns for board array	
	   public static final int ROWS = 4;
	   public static final int COLS = 4;
	   
	   //initiate message variables
	   private GUI square;
	   private Controller controller;
	   private JPanel panel;
	   private JPanel messagePanel;
	   private JLabel bottomTextPanel;

	   //View constructor setups new GUI for game
	   public View(Controller controller)
	   {
	      super();
	      this.controller = controller;
	      this.square = new GUI();
	      setupGUI();      
	   } 

	   //setups all aspectts of board
	   private void setupGUI()
	   {
	      createFrame();
	      msgPanel();
	      createPanel();
	      setupBoard();
	      this.getContentPane().add(panel);
	      panel.addMouseListener(this);
	   } 

   //creates size, title of game at top, location, and border
   private void createFrame()
   {	      
	   setSize(800,800);
	   setTitle("Connect Four");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setLocationRelativeTo(null);
	   setLayout(new BorderLayout());
	   } 
   
   //message panel at bottom of game
   private void msgPanel()
   {  
	   messagePanel = new JPanel();
	   bottomTextPanel = new JLabel("Red piece player start");	      
	   this.getContentPane().add(messagePanel, BorderLayout.SOUTH);
   }

   //creates Panel
   private void createPanel()
   {
      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4, -1, -1));
   } 

   // setups blank spaces on board, size of squares, location, color and size of border
   private void setupBoard()
   {
      for(int loopCell = 0; loopCell < 16; loopCell++)
      {
         JLabel piece = new JLabel();
         piece.setIcon(square.getBlankIcon());
         piece.setSize(new Dimension(800/4,800/4));
         piece.setHorizontalAlignment(JLabel.CENTER);
         piece.setBorder(
               BorderFactory.createMatteBorder(6, 6, 6, 6,Color.GREEN));
         board.add(piece);
         panel.add(piece);
      } 
   }
   
   private void drawSymbol(int index, char symbol)
   {

      JLabel temp = (JLabel) board.get(index);
      temp.setIcon(square.getIcon(symbol));
   } 
   
   private void setCurrentPlayer(char player)
   {
      if(player == 'b'){
         bottomTextPanel.setText("Red piece player's turn");
      }
      else{
         bottomTextPanel.setText("Black piece player's turn");
      }
   }

   public void gameTie() 
   {
      giveMessage("Game Tie", "Tied game :( ");
      reset();
   }

   public void gameWon(char winner) 
   {
	  giveMessage("","Congratulations! ");
	  if(winner == 'r'){
      giveMessage(" ",  "Red piece player won!");
	  }
	  else 
		  giveMessage(" ",  "Black piece player won!");  
      reset();
   }

   //setups message format
   private void giveMessage(String header, String message)
   {
      JOptionPane.showMessageDialog(this,
            message,
            header,
            JOptionPane.PLAIN_MESSAGE);
   } 
   
   //clears board
   private void reset() 
   {
      for(JLabel label : board)
      {
         label.setIcon(square.getBlankIcon());
      }
      panel.repaint();
   }
   
   @Override
   public void playerMove(int position, char player) 
   {
      drawSymbol(position, player);
      setCurrentPlayer(player);
   } 

   @Override
   public void mouseClicked(MouseEvent e) 
   {
   } 

   @Override
   public void mouseEntered(MouseEvent e)
   {
   } 
   
   @Override
   public void mouseExited(MouseEvent e)
   {
   } 

   @Override
   public void mousePressed(MouseEvent e) 
   {
   } 

   @Override
   public void mouseReleased(MouseEvent e) 
   {	   
      int j=4;
      for(int i = 0; i < board.size(); i++)
      {   
         if(board.get(i).getBounds().contains(e.getPoint()))
         {
            controller.playermove(new Point(i/j, i%j));
         }
      }
   }
} 
