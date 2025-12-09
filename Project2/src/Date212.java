//Student's Name: Nafisa Tabassum
//Lab Section:  Object Oriented Programming in Java CSCI 212 121A [49440]: Mon-Wed 02:45 PM – 03:35 PM

// Date212.java
// Represents one date from yyyymmdd string.

/**
 * to store a date as three separate numbers (year, month, day).
 * So that it breaks the string into pieces for easy sorting and comparing 
 * Storing them as integers so we can do math comparisons instead of string checks.
 */
public class Date212 {

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
        // use substring to separate parts
        int y = Integer.parseInt(yyyymmdd.substring(0, 4));
        int m = Integer.parseInt(yyyymmdd.substring(4, 6));
        int d = Integer.parseInt(yyyymmdd.substring(6, 8));

        year = y;
        month =m;
        day =d;
    }

    /**
     * Getter to let other classes see the year number of this date.
     * keep year private, so a getter is needed to access it safely.
     *
     * @return the year part of this date
     */
    public int getYear() { return year; }
    
    /**
     * Setter for year, included because object classes usually provide
     * set and get methods.
     *
     * @param y the year to set
     */ 
    public void setYear(int y) { year = y; }

    /**
     * Getter for month so GUI or sorting code can read it.
     *
     * @return the month number for this date
     */
    public int getMonth() { return month; }
    
    /**
     * Setter for month, included to match standard class structure even if not used.
     *
     * @param m the month value to set
     */  
    public void setMonth(int m) { month = m; }

    /**
     * Getter for day so other parts of the program can display it.
     *
     * @return the day part of this date
     */
    public int getDay() { return day; }
    
    /**
     * Setter for day, part of full class definition even if not directly needed.
     *
     * @param d the day to set
     */ 
    public void setDay(int d) { day = d; }

    
    /**
     * This method is used to display the date in a nicer format.
     * The program uses this for the Sorted Dates column so the output looks clean.
     *
     * @return a formatted date string with month name, day, and year
     */
    public String toString() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};

        return monthNames[month - 1] + " " + day + ", " + year;
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
    
    /**
     * Checks if two Date212 objects represent the same date.
     * Returns true only if year, month, and day all match.
     */
    public boolean equals(Date212 other) {
        if (other == null) return false;
        return (this.year == other.year &&
                this.month == other.month &&
                this.day == other.day);
    }
}
