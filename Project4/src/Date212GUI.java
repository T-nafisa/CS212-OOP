import javax.swing.*;
import java.awt.*;

/**
 * The Date212GUI class creates the graphical user interface 
 */
public class Date212GUI extends JFrame {

    private JTextArea leftArea;
    private JTextArea rightArea;

    /**
     * This constructor sets up the GUI window. It takes two strings- 
     * one for the original dates and one for the sorted dates
     * @param leftText  the full string that shows the original dates
     * @param rightText the full string that shows the sorted dates
     */
    public Date212GUI() {
        setTitle("Date Sorter");          // title of window
        setSize(800, 400); 
        setLocation(300,300);
        setLayout(new GridLayout(1, 2)); // 1 row, 2 columns layout

        // create two text areas
        leftArea = new JTextArea();
        rightArea = new JTextArea();
        
        // only readable
        leftArea.setEditable(false); 
        rightArea.setEditable(false);
        
        add(new JScrollPane(leftArea));
        add(new JScrollPane(rightArea));
        
        createFileMenu();

        setVisible(true);   // show window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    /** Creates the File menu with the items:
     * Open - selects an input file to read dates from
     * Quit - closes the program
     */
    // Using lab19 notes
    private void createFileMenu( ) {
       JMenuItem   item;
       JMenuBar    menuBar  = new JMenuBar();
       JMenu       fileMenu = new JMenu("File");
       FileMenuHandler fmh  = new FileMenuHandler(this);

       item = new JMenuItem("Open");    //Open...
       item.addActionListener( fmh );
       fileMenu.add( item );

       fileMenu.addSeparator();           //add a horizontal separator line
     
       item = new JMenuItem("Quit");       //Quit
       item.addActionListener( fmh );
       fileMenu.add( item );

       setJMenuBar(menuBar);
       menuBar.add(fileMenu);
    }
    
        public void setLeftText(String leftText) {
           leftArea.setText(leftText);
        }
        
        public void setRightText(String rightText) {
           rightArea.setText(rightText);
        }
}
