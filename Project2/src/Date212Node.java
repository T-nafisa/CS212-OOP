// Date212Node.java

/**
 * to represent a single node of linked list.
 * It stores one Date212 object and a link to the next node.
 */
public class Date212Node {
    protected Date212 data;          // holds the actual date
    protected Date212Node next;      // points and links to the next node

    /**
     * One-argument constructor that stores the Date212 data.
     * @param d a Date212 object to store in this node
     */
    public Date212Node(Date212 d) {
        data = d;    // store the given date
        next = null; // set next to null as there's no next node yet
    }
}
