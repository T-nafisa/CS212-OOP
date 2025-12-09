//Student's Name: Nafisa Tabassum
//Lab Section:  Object Oriented Programming in Java CSCI 212 121A [49440]: Mon-Wed 02:45 PM – 03:35 PM

import javax.swing.*; //imports swing for JOptionPane header

public class Project0 {
   public static void main(String[] args) {

      // infinite loop continues until user asks to stop
      while (true) {

         // Ask user to input a sentence
         String sentence = JOptionPane.showInputDialog(null, "Please enter a sentence: ");

         // if user clicks cancel or types "STOP" (in any case), exits the program
         if (sentence == null || sentence.equalsIgnoreCase("Stop"))
            System.exit(0);

         // initialing two integers to count and store total number of upper & lower case e.
         int lowerCase_e = 0, upperCase_E = 0;

         // checks every character and finds out all the "E" and "e" in the sentence.
         for (int i = 0; i < sentence.length(); i++) {

            if (sentence.charAt(i) == 'E')
               upperCase_E++; // increments total # of upper case e if an upper case 'E' is found.

            else if (sentence.charAt(i) == 'e')
               lowerCase_e++; // increments total # of lower case e if an lower case 'e' is found.
         }

         // show the result in a dialog box
         JOptionPane.showMessageDialog(null,
               "Number of lower case e's: " + lowerCase_e + "\nNumber of upper case e's: " + upperCase_E);
      }
   }
}