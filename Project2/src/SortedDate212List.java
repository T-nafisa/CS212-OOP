// SortedDate212List.java

/**
 * Stores Date212s in sorted order automatically.
 */
public class SortedDate212List extends Date212List {

   public SortedDate212List() {
      super(); 
  }

    /**
     * Adds a new Date212 to the list in sorted order.
     */
    public void add(Date212 d) {
        Date212Node newNode = new Date212Node(d);
        Date212Node current = first; // start at dummy head

        // Move until next node is greater or null
        while (current.next != null && current.next.data.compareTo(d) < 0) {
            current = current.next;
        }

        // Insert new node
        newNode.next = current.next;
        current.next = newNode;

        // If added at the end, update last
        if (newNode.next == null)
            last = newNode;

        length++;
    }
}
