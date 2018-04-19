import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIMarker
{
   private static final char EMPTY_MARK = 'E';

   private static Icon[] iconMarkers = new ImageIcon[3];
   private static Icon iconBlank;
   private static boolean iconsLoaded = false;
   private static String iconFolderPath = "./images";

   public GUIMarker()
   {
	   //constructor
      if (!GUIMarker.iconsLoaded)
         GUIMarker.loadMarkIcons();
   } 
   
   public static Icon getIcon(char symbol)
   {
      if (!GUIMarker.iconsLoaded)
      {
         GUIMarker.loadMarkIcons();
      }
      return iconMarkers[valueAsInt(symbol)];
   } 
   
   private static void loadMarkIcons()
   {
      if (!(new File(GUIMarker.iconFolderPath).exists()))
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
         
         GUIMarker.iconFolderPath = selectedFile.getPath();
         System.out.println(iconFolderPath);
      } 

      for (int m = 0; m < Marker.validMarkerValues.length; m++)
      {
      //If can't find piece give player a message and exit 
         if (!new File(iconFolderPath + "/" + Marker.validMarkerValues[m]
               + ".jpg").exists())
            {
               JOptionPane.showMessageDialog(null, Marker.validMarkerValues[m]
                  + ".jpg could not be found in the icon"
                  + " folder. Program execution will now stop.");
               System.exit(0);
            } // end if
            
            iconMarkers[m] = new ImageIcon(iconFolderPath + "/"
               + Marker.validMarkerValues[m] + ".jpg");

      } 
 
      iconBlank =  new ImageIcon(iconFolderPath + "/y.jpg");
      GUIMarker.iconsLoaded = true; 
   } 

   private static int valueAsInt(char symbol)
   {
      String values = new String(Marker.validMarkerValues);
      int returnValue = values.indexOf(symbol);
      
      if (returnValue < 0)
      {
         returnValue = values.indexOf(EMPTY_MARK);
      }
      return returnValue;
   } 

   public Icon getBlankIcon()
   {
      //Load all unloaded icons 
      if (!GUIMarker.iconsLoaded)
         GUIMarker.loadMarkIcons(); 
      return GUIMarker.iconBlank;
   } 
} 

