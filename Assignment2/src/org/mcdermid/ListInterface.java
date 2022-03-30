package org.mcdermid;

public interface ListInterface<T> {

    /**
     * Add item to end of list
     * @param item Item to add
     * @throws ListException Exceptional conditions
     */
    public void add(T item) throws ListException;

    /**
     * Add item to location in list
     * @param item Item to add
     * @param pos Location to add item to
     * @throws ListException Exceptional conditions
     */
    public void add(T item, int pos) throws ListException;

    /**
     * Retrieve item from list
     * @param pos Where to retrieve from
     * @return Item
     * @throws ListException Exceptional conditions.
     */
    public T get(int pos) throws ListException;

    /**
     * Set an index to a value
     * @param item value to set to
     * @param pos index to set
     * @return old value at index
     * @throws ListException Exceptional conditions.
     */
    public T set(T item, int pos) throws ListException;

    /**
     * Find an object in the list
     * @param target Object to find
     * @param start Where to start looking
     * @param end Where to stop looking
     * @return Item's location (-1 if not found)
     * @throws ListException Exceptional conditions.
     */
    public int find(T target, int start, int end) throws ListException;

    /**
     * Returns size of list.
     * @return Size of list.
     */
    public int size();

    /**
     * Returns a String containing the toString of each element
     * @return String
     */
    public String toString();

    /**
     * Removes an element from the list and shifts everything behind it down one
     * @param pos WHere to delete?
     * @return Item deleted
     * @throws ListException Exceptional conditions.
     */
    public T remove(int pos) throws ListException;

    /**
     * Deletes entire list.
     */
    void clear();

    /**
     * Return list as array
     * @return Array.
     */
    T[] toArray();

    /**
     * Is the array empty?
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();
}
