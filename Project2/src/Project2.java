//Student's Name: Nafisa Tabassum
//Lab Section:  Object Oriented Programming in Java CSCI 212 121A [49440]: Mon-Wed 02:45 PM – 03:35 PM

// Project2.java

import java.util.StringTokenizer;

/**
 * Main class that reads the input file and fills two linked lists:
 * one unsorted and one sorted.
 */
public class Project2 {

    public static void main(String[] args) {
        UnsortedDate212List unsortedList = new UnsortedDate212List();
        SortedDate212List sortedList = new SortedDate212List();

        TextFileInput file = new TextFileInput("Project2Data.txt");
        String line = file.readLine();

        while (line != null) {
            StringTokenizer tokens = new StringTokenizer(line, ",");
            
            while (tokens.hasMoreTokens()) {
                String raw = tokens.nextToken();
                Date212 date = new Date212(raw);

                unsortedList.add(date);
                sortedList.add(date);
            }
            line = file.readLine();
        }
        file.close();
        
        // Build strings for GUI display
        String leftText = "Unsorted Dates:\n\n" + unsortedList.toStringRaw();
        String rightText = "Sorted Dates:\n\n" + sortedList.toString();

        new Date212GUI(leftText, rightText);
    }
}
