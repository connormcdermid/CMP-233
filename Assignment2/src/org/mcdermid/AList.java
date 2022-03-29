package org.mcdermid;

public class AList<T> implements ListInterface<T> {

    private T[] items;

    private int counter;

    public AList() {
        this.counter = 0;
        this.items = (T[]) new Object[20];
    }

    private boolean full() {
        return this.items.length >= this.counter;
    }

    @Override
    public void add(T item) throws ListException {
        if (full()) {
            throw new ListException("Error. Unable to add. List is full or not enough memory.");
        }
        if (item == null) {
            throw new ListException("Error. Unable to add. Cannot add null entries.");
        }
        this.items[this.counter++] = item; // add item and increment counter
    }

    public void add(T item, int pos) throws ListException {
        if (full()) {
            throw new ListException("Error. Unable to insert. List is full.");
        }
        if (item == null) {
            throw new ListException("Error. Unable to insert. Attempt to insert null object.");
        }
        if (pos > this.counter) {
            throw new ListException("Error. Unable to insert. Bad position.");
        }
    }
}
