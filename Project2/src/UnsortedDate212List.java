// UnsortedDate212List.java

/**
 * Stores Date212s in the same order as they were read.
 */
public class UnsortedDate212List extends Date212List {

    public UnsortedDate212List() {
        super(); // call parent constructor
    }

    /**
     * Adds a new Date212 to the end of the list.
     */
    public void add(Date212 d) {
        super.append(d); 
    }
}
