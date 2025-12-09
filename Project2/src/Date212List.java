// Date212List.java

/**
 * This is an abstract linked list that stores Date212Nodes.
 * It manages the common structure and append logic.
 */
public abstract class Date212List {
    protected Date212Node first;   // head node (dummy)
    protected Date212Node last;    // points to the last node
    protected int length;          // number of real data nodes

    /**
     * Constructor to create an empty list with a dummy head node.
     */
    public Date212List() {
        first = new Date212Node(null); // dummy node, no actual date
        last = first;                  // when empty, last = head
        length = 0;
    }

    /**
     * Appends a new node containing the given date to the end of the linked list.
     * @param d the Date212 object want to add
     */
    public void append(Date212 d) {
        Date212Node newNode = new Date212Node(d); // make a new node with given date
        last.next = newNode;   // link old last to new node
        last = newNode;        // update last pointer
        length++;
    }
    
    /**
     * Convert the linked list into a readable string for GUI display
     * for sorted list printing
     */
    public String toString() {
        String result = "";
        Date212Node current = first.next; // skip dummy head
        while (current != null) {
            result += current.data.toString() + "\n";
            current = current.next;
        }
        return result;
    }
    
    /** For unsorted list printing */
       public String toStringRaw() {
       String result = "";
       Date212Node current = first.next;

       while (current != null) {
           Date212 d = current.data;
           
           // show raw format as given in original text file
           String raw = d.getYear() +
                   (d.getMonth() < 10 ? "0" : "") + d.getMonth() +
                   (d.getDay() < 10 ? "0" : "") + d.getDay();

           result += raw + "\n";
           current = current.next;
       }
       return result;
   } 
}
