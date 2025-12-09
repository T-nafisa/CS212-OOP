//Student's Name: Nafisa Tabassum
//Lab Section:  Object Oriented Programming in Java CSCI 212 121A [49440]: Mon-Wed 02:45 PM – 03:35 PM
//Project1.java


import java.util.StringTokenizer;

/**
 * This class contains the main method required to run the whole project.
 * Its job is to read dates from the file, store them, sort them, and then
 * pass them to the GUI for display. Keeping everything here to control
 * the overall flow of the program.
 */
public class Project1 {
   
   /**
    * The main method is needed to start the program. It coordinates reading data,
    * storing objects, sorting them, and opening the GUI. Without this, nothing runs.
    */
    public static void main(String[] args) {

        Date212[] dateArray = new Date212[500]; // array to store Date212 objects
        String[] rawDates = new String[500];    // array to store raw strings exactly as read
        int dateCount = 0; // count how many dates we sorted

        TextFileInput file = new TextFileInput("Project1Data.txt");
        String line = file.readLine();

     // Read file line by line to get all dates
        while (line != null) {
            // split lines using comma
            StringTokenizer tokens = new StringTokenizer(line, ",");
            while (tokens.hasMoreTokens()) {
                String raw = tokens.nextToken();
                rawDates[dateCount] = raw; 
                dateArray[dateCount] = new Date212(raw); // create Date212 object & store it 
                dateCount++;
            }
            line = file.readLine(); // read next line
        }

        // create left column text
        String leftText = " Original Dates:\n\n";
        for (int i = 0; i < dateCount; i++) {
            leftText += "  " + rawDates[i] + "\n";
        }

        // Sort dateArray using selection sort
        selectionSort(dateArray, dateCount);

        // right text = sorted formatted output
        String rightText = "Sorted Dates:\n\n";
        for (int i = 0; i < dateCount; i++) {
            rightText += dateArray[i].toString() + "\n";
        }

        // Show results in GUI window
        new DateGUI(leftText, rightText);
    }

    /**
     * This method is to sorting manually using selection sort.
     * This function compares Date212 objects using the compare() method.
     *
     * @param arr  the array of Date212 objects to be sorted
     * @param size the number of actual elements stored (not the full array length)
     */
    private static void selectionSort(Date212[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int indexLowest = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j].compare(arr[indexLowest]) < 0) { 
                    indexLowest = j; 
                }
            }
            // swap 
            Date212 temp = arr[indexLowest];
            arr[indexLowest] = arr[i];
            arr[i] = temp;
        }
    }
}
