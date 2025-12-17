//Student's Name: Nafisa Tabassum
//Lab Section:  Object Oriented Programming in Java CSCI 212 121A [49440]: Mon-Wed 02:45 PM – 03:35 PM

// Date212.java

/**
 * This class represents one date from yyyymmdd string.
 * to store a date as three separate numbers (year, month, day).
 * So that it breaks the string into pieces for easy sorting and comparing 
 * Storing them as integers so we can do math comparisons instead of string checks.
 */
public class Date212 implements Comparable<Date212> {

    // store year, month, day as numbers
    private int year;
    private int month;
    private int day;

    /**
     * This constructor takes a single date string then split it into year, month,
     * and day so other parts of the program can use those values separately.
     *
     * @param yyyymmdd the raw date string from the input file without any slashes or spaces
     */
    public Date212(String yyyymmdd) {
       
       // Check if 8 digits string
       if (!yyyymmdd.matches("\\d{8}")) {
          throw new IllegalDate212Exception("Invalid date format: "+ yyyymmdd);
       }
    
        // use substring to Extract values
        year = Integer.parseInt(yyyymmdd.substring(0, 4));
        month = Integer.parseInt(yyyymmdd.substring(4, 6));
        day = Integer.parseInt(yyyymmdd.substring(6, 8));
        
        // Check month validity
        if(month<1 || month>12) {
           throw new IllegalDate212Exception("Invalid month");
        }
        
        // Check day validity
        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int max = maxDays[month - 1];

        if (day < 1 || day > max) {
            throw new IllegalDate212Exception("Invalid day " + day + " for month " + month);
        }
    }

    /** Getter methods 
     * returns the year, month day as integer */
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    
    /**
     * This method is used to display the date in a nicer format.
     * The program uses this for the Sorted Dates column so the output looks clean.
     *
     * @return a formatted date string with week, month name, day, and year
     */
    public String toString() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};
        
        String[] dayNames = {"Sunday","Monday","Tuesday","Wednesday",
              "Thursday","Friday","Saturday"};

        int weekday = getDayOfWeek();  // to compute the week days name

        return dayNames[weekday] + ", " + monthNames[month - 1] + " " + day + ", " + year;
    }
    
    /**
     * Computes the day of the week using Zeller's Congruence.
     * @return weekday number (0= Sunday, 1= Monday,...., 6= Saturday)
     */
    private int getDayOfWeek() {
       int q= day;
       int m= month;
       int y= year;
       
       /* The formula requires to count January and February 
        * as months 13 and 14 of previous year
        */
       if(m==1) {
          m=13;
          y--;
       }else if(m==2) {
          m=14;
          y--;
          }
       
       int k= y%100; // year of century
       int j= y/100; // zero based century
       
       // Zeller's congruence formula
       int h= (q+ (26*(m+1))/10 + k + (k/4) + (j/4) + 5*j) %7;
    
    /* Need to adjust the formula because standard formula uses h=0=Saturday
     But this Project requires h=0=Sunday */
     int adjusted= (h+6)%7;
     return adjusted;
}

    /**
     * Compares dates, returns a positive or negative number so we know which date comes first.
     *
     * @param other another Date212 object to compare with this one
     * @return negative if this date is earlier, positive if later, 0 if equal
     */
    public int compareTo(Date212 other) {
        if (this.year != other.year)
            return this.year - other.year; // earlier month means earlier date

        if (this.month != other.month)
            return this.month - other.month; // if same year, check month

        return this.day - other.day;   // if same month, check day
    }
   
}
