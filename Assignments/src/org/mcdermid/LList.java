package org.mcdermid;

/**
 * A linked-list implementation of an ordered list. For the
 * array implementation, see {@link org.mcdermid.AList}
 * @param <T> Type of object to store.
 * @author Connor McDermid
 * @see org.mcdermid.ListInterface
 * @see org.mcdermid.Node
 */
public class LList<T> implements ListInterface<T> {

    private Node<T> head;

    private Node<T> tail;

    private int counter;

    public LList() {
        this.head = null;
        this.tail = null;
        this.counter = 0;
    }

    public LList(Node<T> obj) {
        this.head = obj;
        this.tail = obj;
        this.counter = 1;
    }

    public LList(T obj) {
        this.head = new Node<T>(obj, null, null);
        this.tail = this.head;
        this.counter = 1;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void add(Node<T> obj) {
        if (counter == 0) {
            this.head = obj;
            this.tail = obj;
        }
        this.tail.setNext(obj);
        obj.setPrev(this.tail);
        this.tail = obj;
    }

    public void add(T obj) throws ListException {
        if (obj == null) {
            throw new ListException("Error. Unable to add. Object is null.");
        }
        if (counter == 0) {
            try {
                this.head = new Node<T>(obj, null, null);
            } catch (OutOfMemoryError e) {
                throw new ListException("Error. Unable to add. Insufficient memory.");
            }
            this.tail = this.head;
            counter += 1;
        }
        try {
            this.tail.setNext(new Node(obj, null, this.tail));
        } catch (OutOfMemoryError e) {
            throw new ListException("Error. Unable to add. Insufficient memory.");
        }
        this.tail = this.tail.getNext();
        counter += 1;
    }

    public void add(T obj, int pos) throws ListException {
        if (obj == null) {
            throw new ListException("Error. Unable to insert. Cannot insert null elements.");
        }
        if (counter == 0) {
            throw new ListException("Error. Unable to insert. List is empty.");
        }
        if (pos == counter) {
            add(obj);
        }
        if (pos > counter || pos < 1) {
            throw new ListException("Error. Unable to insert. Bad position.");
        }
        pos--;
        int i = 0;
        Node<T> curr = this.head;
        Node<T> newNode;
        try {
            newNode = new Node<T>(obj, null, null);
        } catch (OutOfMemoryError e) {
            throw new ListException("Error. Unable to insert. Out of memory.");
        }
        do {
            if (i == pos) {
                Node<T> prev = curr.getPrev();
                prev.setNext(newNode);
                curr.setPrev(newNode);
                newNode.setPrev(prev);
                newNode.setNext(curr);
                counter += 1;
                return;
            } else {
                curr = curr.getNext();
                pos++;
            }
        } while (i < pos);
    }

    public T get(int n) throws ListException {
        if (n > this.counter || n < 1) {
            throw new ListException("Error. Unable to get. Bad position.");
        }
        if (isEmpty()) {
            throw new ListException("Error. Unable to get. List is empty.");
        }
        if (n == counter) {
            return this.tail.getValue();
        }
        n--; // 0-based
        int i = 0;
        Node<T> curr = this.getHead();
        do {
            if (i == n) {
                return curr.getValue();
            } else {
                curr = curr.getNext();
                i++;
            }
        } while (i < n);
        return null;
    }

    /**
     * Gets the node at an index
     * @param n Index
     * @return Node at index
     * @throws ListException Exceptional conditions
     */
    public Node<T> getNode(int n) throws ListException {
        if (n > this.counter || n < 1) {
            throw new ListException("Error. Unable to get. Bad position.");
        }
        if (isEmpty()) {
            throw new ListException("Error. Unable to get. List is empty.");
        }
        if (n == counter) {
            return this.tail;
        }
        n--; // 0-based
        int i = 0;
        Node<T> curr = this.getHead();
        do {
            if (i == n) {
                return curr;
            } else {
                curr = curr.getNext();
                i++;
            }
        } while (i < n);
        return null;
    }

    /**
     * Set an index to a value, replacing the value at that index
     * @param obj
     * @param pos index to set
     * @return Item that was replaced
     * @throws ListException
     */
    public T set(T obj, int pos) throws ListException {
        if (obj == null) {
            throw new ListException("Error. Unable to set. Cannot be null.");
        }
        if (isEmpty()) {
            throw new ListException("Error. Unable to set. Empty list.");
        }
        if (pos > counter || pos < 1) {
            throw new ListException("Error. Unable to set. Bad position.");
        }
        pos--;
        int i = 0;
        Node<T> curr = this.getHead();
        T ret = null;
        do {
            if (i == pos) {
                ret = curr.getValue();
                curr.setValue(obj);
            } else {
                curr = curr.getNext();
                i++;
            }
        } while (i < pos);
        return ret;
    }

    public T remove(int pos) throws ListException {
        pos--;
        if (isEmpty()) {
            throw new ListException("Error. Unable to remove. List is empty.");
        }
        if (pos >= this.counter || pos < 0) {
            throw new ListException("Error. Unable to remove. Bad position.");
        }
        T tmp = this.get(pos);
        this.getNode(pos - 1).setPrev(this.getNode(pos + 1));
        this.getNode(pos - 1).setNext(this.getNode(pos + 1));
        counter -= 1;
        return tmp;
    }

    /**
     * Finds a T object inside the list
     * @param target Object to find
     * @param start Where to start looking
     * @param end Where to stop looking
     * @return Item's location (-1 if not found)
     * @throws ListException Exceptional conditions.
     */
    public int find(T target, int start, int end) throws ListException {
        start--;
        end--;
        if (target == null) {
            return -1;
        }
        if (start > end) {
            return -1;
        }
        if (start == end && this.get(start) == target) {
            return start + 1; // compensate for correction factor at beginning
        } else if (start == end) { // will only trigger if true and above 2nd clause is false
            return -1;
        }
        Node<T> curr = this.getNode(start);
        for (int i = start; i < end; i++) {
            if (curr.getValue().equals(target)) {
                return i + 1;
            } else {
                curr = curr.getNext();
            }
        }
        return -1;
    }

    /**
     * Returns size of list
     * @return Size of list
     */
    public int size() {
        return this.counter;
    }

    /**
     * Clears the array by setting head and tail to null.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Returns list as array
     * @return Array containing list
     */
    public T[] toArray() {
        T[] arr = (T[]) new Object[counter];
        Node<T> curr = this.getHead();
        for (int i = 0; i < counter; i++) {
            arr[i] = curr.getValue();
            curr = curr.getNext();
        }
        return arr;
    }

    public String toString() {
        if (isEmpty()) {
            return "The list is empty.\n";
        }
        StringBuilder out = new StringBuilder(new String(""));
        Node<T> curr = this.head;
        for (int i = 0; i < counter; i++) {
            out.append(curr.getValue()).append("\n");
            curr = curr.getNext();
        }
        return out.toString();
    }

}
