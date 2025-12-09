// Date212GUI.java

import javax.swing.*;
import java.awt.*;

public class Date212GUI extends JFrame {

    private JTextArea leftArea;
    private JTextArea rightArea;

    /**
     * This constructor sets up the GUI window. It takes two strings- 
     * one for the original dates and one for the sorted dates
     * @param leftText  the full string that shows the original dates
     * @param rightText the full string that shows the sorted dates
     */
    public Date212GUI(String leftText, String rightText) {
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
