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
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUI
{
   private static String iconFolderPath = "./images";
   private static final char BLANK = 'y';
   private static Icon[] pieces = new ImageIcon[3];
   private static Icon iconBlank;
   private static boolean iconsLoaded = false;
   
   public GUI()
   {
	   //constructor
      if (!GUI.iconsLoaded)
         GUI.loadPieces();
   }
   
   public Icon getBlankIcon()
   {
      //Load all empty squares 
      if (!GUI.iconsLoaded)
         GUI.loadPieces(); 
      return GUI.iconBlank;
   } 
   
   private static void loadPieces()
   {
      if (!(new File(GUI.iconFolderPath).exists()))
      {
         JOptionPane.showMessageDialog(null, "Can't find image Press OK and choose the folder "
         		+ "with game piece images. Press cancel to exit this program.");
         JFileChooser chooser = new JFileChooser(".");
         chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         chooser.setMultiSelectionEnabled(false);
         chooser.showDialog(null, "Select");
         File selectedFile = chooser.getSelectedFile();
         
         if (selectedFile == null)
            System.exit(0);
         
         GUI.iconFolderPath = selectedFile.getPath();
         System.out.println(iconFolderPath);
      } 

      for (int i = 0; i < position.validPieces.length; i++)
      {
      //If can't find piece give player a message and exit 
         if (!new File(iconFolderPath + "/" + position.validPieces[i]
               + ".jpg").exists())
            {
               JOptionPane.showMessageDialog(null, position.validPieces[i]
                  + ".jpg could not be found in the icon"
                  + " folder. Program execution will now stop.");
               System.exit(0);
            }         
            pieces[i] = new ImageIcon(iconFolderPath + "/"
               + position.validPieces[i] + ".jpg");
      } 
      iconBlank =  new ImageIcon(iconFolderPath + "/y.jpg");
      GUI.iconsLoaded = true; 
   } 
   
   public static Icon getIcon(char piece)
   {
      if (!GUI.iconsLoaded)
      {
         GUI.loadPieces();
      }
      return pieces[valueAsInt(piece)];
   } 

   private static int valueAsInt(char piece)
   {
      String values = new String(position.validPieces);
      int returnValue = values.indexOf(piece);
      
      if (returnValue < 0)
      {
         returnValue = values.indexOf(BLANK);
      }
      return returnValue;
   } 
} 

