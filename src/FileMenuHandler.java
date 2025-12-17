import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.TreeMap;

/**
 * This class uses menu selections from the GUI.
 * It handles the actions for the "Open" and "Quit" menu items.
 * When the user selects "Open", a file chooser appears and the
 * selected file is read and processed.
 */
public class FileMenuHandler implements ActionListener {
   Date212GUI gui;

   public FileMenuHandler(Date212GUI g) {
      gui = g;
   }

   /**
    * This allow to responds to menu selections. If the user clicks "Open", a file chooser
    * window is displayed. If "Quit" is clicked, the program exits.
    *
    * @param event the menu item action event
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      
      if (menuName.equals("Open"))
         openFile(); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed
   
   // Open a file using JFileChooser
   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      int status = chooser.showOpenDialog(null);

      if (status != JFileChooser.APPROVE_OPTION)
         return;

      File file = chooser.getSelectedFile();
      readFile(file);
}//openFile
   
   /** 
    * to read the file and sort with TreeMap
    * Valid dates are added to a TreeMap, which automatically sorts them and removes duplicates. 
    * Invalid dates are handled by an IllegalDate212Exception, and the error message is printed to the console.
    * The unsorted raw dates and sorted unique dates are displayed in the GUI.
    * @param file the file chosen by user
    */
   private void readFile(File file) {

      // Left side of GUI (unsorted raw dates)
      String unsortedOutput = "Unsorted Dates:\n\n";

      // TreeMap will automatically sort AND remove duplicates
      TreeMap<Date212, Object> sortedMap = new TreeMap<>();

      try {
          TextFileInput in = new TextFileInput(file.getAbsolutePath());
          String line = in.readLine();

          while (line != null) {

              String[] tokens = line.split(",");

              for (String token : tokens) {
                 String s = token.trim();

                  try {
                     Date212 d = new Date212(s);

                     unsortedOutput = unsortedOutput + s + "\n";
                     sortedMap.put(d, null);   // value is null

                 } catch (IllegalDate212Exception ex) {
                     System.out.println("Invalid date found: " + s);
                     System.out.println(ex.getMessage());
                 }
             }

             line = in.readLine();
         }

     } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
     }

      // Sorted output (right side of GUI)
      String sortedOutput = "Sorted Unique Dates:\n\n";
      
     for (Date212 d : sortedMap.keySet()) {
        sortedOutput = sortedOutput + d.toString() + "\n";
     }

     // Update GUI
     gui.setLeftText(unsortedOutput);
     gui.setRightText(sortedOutput);
 }//readFile
}//FileMenuHandler

   