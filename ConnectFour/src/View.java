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
   private static final Color COLOR_BLUE = new Color(0, 0, 255);
   //
   //  ----- Public Attributes  ---
   //

   public static final int NUM_ROWS = 4;
   public static final int NUM_COLS = 4;

   //
   //  ----- Private Attributes  ---
   //

   private GUIMarker gameMarkers;

   private Controller controller;
   private JPanel panel;
   //
   // Dynamic array. This was covered in chapter 14 of book, it is sweet.
   //
   ArrayList<JLabel> board = new ArrayList<JLabel>();

   private JLabel [][] board2 = new JLabel[NUM_ROWS][NUM_COLS];

   private JPanel messagePanel;
   private JLabel topText;


   //*************************************************
   //*
   //* Constructors
   //*
   //*************************************************
   /* 
    * View(Controller controller)
    * In: Controller
    * Out: Nothing
    * Description: This is the only constructor. 
    *              It takes a link to the main driver for the controller
    *              This is so the controller can decide what to do about
    *              user clicks
    *              
    */

   public View(Controller controller)
   {
      super();
      this.controller = controller;
      this.gameMarkers = new GUIMarker();
      setupGUI();      
   } // end View constructor


   //*****************************************************
   // 
   //  Helper methods
   //
   //*****************************************************
   /* 
    * void setupGUI()
    * In: Nothing
    * Out: none
    * Description: setups the board for playing
    * 
    */

   private void setupGUI()
   {
      createFrame();
      msgPanel();
      createPanel();
      setupBoard();

      //Adds the panel to the frame
      this.getContentPane().add(panel);
      panel.addMouseListener(this);
   } 

   private void setupBoard()
   {
      for(int loopCell = 0; loopCell < 16; loopCell++)
      {
         JLabel piece = new JLabel();
         piece.setIcon(gameMarkers.getBlankIcon());
         piece.setSize(new Dimension(800/4,800/4));
         piece.setHorizontalAlignment(JLabel.CENTER);
         piece.setBorder(
               BorderFactory.createMatteBorder(6, 6, 6, 6,Color.GREEN));

         board.add(piece);
         panel.add(piece);
      } 
   }

   private void createFrame()
   {
      setSize(800,800);
      setTitle("Tic-Tac-Toe");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLocationRelativeTo(null);
      setLayout(new BorderLayout());

   } 

   private void msgPanel()
   {
	   //msgPanel on bottom
      messagePanel = new JPanel();
      topText = new JLabel("Red piece player start");
      
      this.getContentPane().add(messagePanel, BorderLayout.SOUTH);
   }

   private void createPanel()
   {
	   //4by4 board
      panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4, -1, -1));
   } 

   @Override
   public void playerMove(int position, char player) 
   {
      setPiece(position, player);
      setCurrentPlayer(player);
   } 

   private void setPiece(int index, char piece)
   {
      JLabel temp = (JLabel) board.get(index);
      temp.setIcon(gameMarkers.getIcon(piece));
   } 

   private void setCurrentPlayer(char player)
   {
      if(player == 'b'){
         topText.setText("Red piece player's turn");
      }
      else{
         topText.setText("Black piece player's turn");
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

   private void giveMessage(String header, String message)
   {
      JOptionPane.showMessageDialog(this,
            message,
            header,
            JOptionPane.PLAIN_MESSAGE);
   } 
   
   private void reset() 
   {
      for(JLabel label : board)
      {
         label.setIcon(gameMarkers.getBlankIcon());
      }
      panel.repaint();
   }
//Override
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
