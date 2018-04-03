import os
import random
import time
from abc import ABCMeta, abstractmethod

import Point

class View: 
    COLOR_BLUE = Color(0, 0, 255);
   #
   #  ----- Public Attributes  ---
   #

    NUM_ROWS = 4;
    NUM_COLS = 4;

   #
   #  ----- Private Attributes  ---
   #
    gameMarkers=GUIMarker()
    controller=Controller()
    panel=JPanel()
   #
   # 

    board = ArrayList<JLabel>()

    board2 =JLabel[NUM_ROWS][NUM_COLS]

    JmessagePanel=JPanel()
    topText=JPanel()


    #*************************************************
    #
    # Constructors
    #
    #*************************************************
    # 
    # View(Controller controller)
    # In: Controller
    # Out: Nothing
    # Description: This is the only constructor. 
    #              It takes a link to the main driver for the controller
    #              This is so the controller can decide what to do about
    #              user clicks
    #              
    #

    def View(controller):
      this.controller = controller;
      this.gameMarkers = GUIMarker();
      setupGUI();      
     # end View constructor


     #*****************************************************
     # 
     #  Helper methods
     #
     #*****************************************************
     # 
     # void setupGUI()
     # In: Nothing
     # Out: none
     # Description: setups the board for playing
     # 
     #

    def setupGUI():
      createFrame();
      msgPanel();
      createPanel();
      setupBoard();

      #Adds the panel to the frame
      this.getContentPane().add(panel);
      panel.addMouseListener(this); 

    def setupBoard():
      for loopCell in [0,15]: 
          piece = JLabel()
          piece.setIcon(gameMarkers.getBlankIcon())
          piece.setSize(new Dimension(800/4,800/4))
          piece.setHorizontalAlignment(JLabel.CENTER)
          piece.setBorder(BorderFactory.createMatteBorder(6, 6, 6, 6,Color.GREEN))

          board.add(piece)
          panel.add(piece) 
   
    def createFrame(self):
      setSize(800,800)
      setTitle("Connect Four")
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

      setLocationRelativeTo(null)
      setLayout(BorderLayout()) 

    def msgPanel(self):
	   #msgPanel on bottom
      messagePanel = JPanel();
      topText = JLabel("Red piece player start")
      
      this.getContentPane().add(messagePanel, BorderLayout.SOUTH)

    def createPanel(self):
	  #4by4 board
      panel = JPanel()
      panel.setLayout(GridLayout(4, 4, -1, -1))

    @Override
    def playerMove(position, player): 
      setPiece(position, player)
      setCurrentPlayer(player) 

    def setPiece(index, piece):
      temp = (JLabel) Model.board.get(index)
      temp.setIcon(gameMarkers.getIcon(piece))

    def setCurrentPlayer(player):
      if player == 'b':
         topText.setText("Red piece player's turn")
      else:
         topText.setText("Black piece player's turn")

    def gameTie(self): 
      giveMessage("Game Tie", "Tied game :( ")
      reset()

    def giveMessage(header, message):
      JOptionPane.showMessageDialog(this,
            message,
            header,
            JOptionPane.PLAIN_MESSAGE)

    def gameWon(winner): 
	  giveMessage("","Congratulations! ")
	  if winner == 'r':
          giveMessage(" "),  ("Red piece player won!")
	  else: 
		 giveMessage (" "),  "Black piece player won!") 
      reset()
   
   def reset(self):
      for(JLabel.label : board):
         label.setIcon(gameMarkers.getBlankIcon())
      panel.repaint()
   
   def mouseReleased(MouseEvent e):	   
      j=4
      for i in range(0, board.size()):  
         if(board.get(i).getBounds().contains(e.getPoint())):
            controller.playermove(new Point(i/j, i%j))

   mouseClicked(MouseEvent e) 
    
   mouseEntered(MouseEvent e)
   
   mouseExited(MouseEvent e)
   
   mousePressed(MouseEvent e) 