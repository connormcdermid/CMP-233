package org.mcdermid;

/**
 * Implementation of List and {@link org.mcdermid.ListInterface} with Arrays
 * @param <T> Type of object to store
 * @author Connor McDermid
 */
public class AList<T> implements ListInterface<T> {

    /**
     * Array that items are stored in -- initialised to size of 20 by default
     */
    private T[] items;

    /**
     * How many items are in the list?
     */
    private int counter;

    /**
     * Default constructor -- initialises array to size of 20 and sets counter to 0
     */
    public AList() {
        this.counter = 0;
        //noinspection unchecked
        this.items = (T[]) new Object[20];
    }

    /**
     * Is this string full?
     * @return true if full, false otherwise.
     */
    private boolean isFull() {
        return this.items.length >= this.counter;
    }

    /**
     * Is this list empty?
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return this.counter == 0;
    }

    /**
     * Adds an item to the end of the list
     * @param item Item to add
     * @throws org.mcdermid.ListException Exceptional conditions: full list, null entry.
     */
    @Override
    public void add(T item) throws org.mcdermid.ListException {
        if (isFull()) {
            throw new org.mcdermid.ListException("Error. Unable to add. List is full or not enough memory.");
        }
        if (item == null) {
            throw new org.mcdermid.ListException("Error. Unable to add. Cannot add null entries.");
        }
        this.items[this.counter++] = item; // add item and increment counter
    }

    /**
     * Insert an item into a particular place
     * @param item What to insert
     * @param pos Where to insert it
     * @throws org.mcdermid.ListException Exceptional conditions: full list, null object, bad position.
     */
    public void add(T item, int pos) throws org.mcdermid.ListException {
        if (isFull()) {
            throw new org.mcdermid.ListException("Error. Unable to insert. List is full.");
        }
        if (item == null) {
            throw new org.mcdermid.ListException("Error. Unable to insert. Attempt to insert null object.");
        }
        if (pos > this.counter) {
            throw new org.mcdermid.ListException("Error. Unable to insert. Bad position.");
        }
        for (int i = this.counter - 1; i >= pos; i--) {
            this.items[i + 1] = this.items[i];
        }
        this.items[pos] = item;
        this.counter++;
    }

    /**
     * Retrieves a reference to the specified item.
     * @param pos Specification (1-based)
     * @return The specified item
     * @throws org.mcdermid.ListException If the list is empty or the position supplied is bad, ListException will be thrown
     */
    public T get(int pos) throws org.mcdermid.ListException {
        pos--; // client uses a 1-based system -- correct
        if (isEmpty()) {
            throw new org.mcdermid.ListException("Error. Unable to get. List is empty.");
        }
        if (pos >= counter || pos < 0) {
            throw new org.mcdermid.ListException("Error. Unable to get. Bad position.");
        }
        return this.items[pos]; // I recognise that providing the client with a direct reference to the
        // object is dangerous, but in order to clone a generic type I need reflection and that's pretty complex.
        // plus, I'm lazy. Maybe I'll do it later.
    }

    /**
     * Sets the specified index (1-based) to a value, and returns the previous value.
     * @param obj Value to set
     * @param pos Set position
     * @return The value to have been replaced
     * @throws org.mcdermid.ListException if the item is null, the position is bad, or the list is empty.
     */
    public T set(T obj, int pos) throws org.mcdermid.ListException {
        pos--; // correct 1-based system
        if (isEmpty()) {
            throw new org.mcdermid.ListException("Error. Unable to replace. List is empty.");
        }
        if (obj == null) {
            throw new org.mcdermid.ListException("Error. Unable to replace. Replacement cannot be null.");
        }
        if (pos >= counter || pos < 0) {
            throw new org.mcdermid.ListException("Error. Unable to replace. Bad position.");
        }
        T ret = this.items[pos];
        this.items[pos] = obj;
        return ret;
    }

    /**
     * Removes and returns a specified element. Collapses the list behind it.
     * @param pos Element specification (1-based)
     * @return The element removed from the list
     */
    public T remove(int pos) throws org.mcdermid.ListException {
        pos--; // correct for 1-based
        if (isEmpty()) {
            throw new org.mcdermid.ListException("Error. Unable to remove. List is empty.");
        }
        if (pos >= this.counter || pos < 0) {
            throw new ListException("Error. Unable to remove. Bad position.");
        }
        T tmp = this.items[pos];
        this.items[pos] = null;
        for (int i = pos; i < counter; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.counter--;
        return tmp;
    }

    public int size() {
        return this.counter;
    }

    /**
     * Finds the target object in a subset of the list. Linear find first, because there is no guarantee T is Comparable.
     * @param target The object to find
     * @param start The index to start the search (1-based)
     * @param end The index to stop the search (1-based)
     * @return The index of the element, or -1 if not found.
     */
    public int find(T target, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (target == null) { // target is nullable, but will return -1 as null cannot be found in the list
            return -1;
        }
        start--; // correct 1-based
        end--;
        for (int i = start; i < end; i++) {
            if (this.items[i].equals(target)) {
                return ++i; // return 1-based position
            } else {
                continue; // continue just for readability
            }
        }
        return -1;
    }

    /**
     * Clears the array by reassigning the reference variable to an empty T[] and resets Counter
     */
    public void clear() {
        this.items = (T[]) new Object[20]; // why bother with a loop when I can just delete the reference?
        counter++;
    }

    /**
     * Returns the contents of the list as a T[] array.
     * @return Contents as array.
     */
    public T[] toArray() {
        if (isFull()) {
            return this.items; // fast return, O(1) time
        }
        //noinspection unchecked
        T[] ret = (T[]) new Object[this.counter];
        for (int i = 0; i < counter; i++) {
            ret[i] = this.items[i];
        }
        return ret; // slow return, O(n) time
    }

    /**
     * Returns the toString of all objects in the list, each followed by a newline.
     * @return A string of all elements in the list
     */
    public String toString() {
        if (isEmpty()) {
            return "The list is empty.\n";
        }
        StringBuilder out = new StringBuilder(new String(""));
        for (T e : this.items) { // for each element e in items:
            out.append(e).append("\n"); // implicit call to toString on e
        }
        return out.toString();
    }
}
