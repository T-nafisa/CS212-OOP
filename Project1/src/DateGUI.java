// DateGUI.java

import javax.swing.*;
import java.awt.*;

/**
 * This method is added because the assignment requires sorting manually using selection sort.
 * We do not use Arrays.sort() or Comparable. This function compares Date212 objects using
 * the compare() method we wrote in that class.
 *
 * @param arr  the array of Date212 objects to be sorted
 * @param size the number of actual elements stored (not the full array length)
 */
public class DateGUI extends JFrame {

    private JTextArea leftArea;
    private JTextArea rightArea;

    /**
     * This constructor sets up the GUI window. We pass in two strings so the
     * GUI class does not need to know anything about sorting or file input.
     * It only focuses on showing whatever text it is given.
     *
     * @param leftText  the full string that shows the original dates
     * @param rightText the full string that shows the sorted dates
     */
    public DateGUI(String leftText, String rightText) {
        setTitle("Date Sorter");          // title of window
        setSize(800, 400);  
        setLayout(new GridLayout(1, 2)); // 1 row, 2 columns layout

        // create two text areas
        leftArea = new JTextArea();
        rightArea = new JTextArea();
        
        // only readable
        leftArea.setEditable(false); 
        rightArea.setEditable(false);

        leftArea.setText(leftText);
        rightArea.setText(rightText);

        add(leftArea);  // left column
        add(rightArea); // right column
        
        setLocation(200, 200); // move window a bit to center-left of screen
    

        setVisible(true);   // show window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
