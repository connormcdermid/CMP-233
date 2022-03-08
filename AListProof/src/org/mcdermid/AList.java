package org.mcdermid;

import org.mcdermid.exception.ListException;
import org.mcdermid.interfaces.ListInterface;

import java.util.Arrays;
import java.util.List;

public class AList<T> implements ListInterface<T> {

    private T[] items;

    private int counter;

    public AList(int len) {
        items = (T[]) new Object[len];
        counter = 0;
    }

    private boolean checkSpace() {
        return this.counter >= this.items.length;
    }

    public void add(T val) throws ListException {
        if (!checkSpace()) {
            throw new ListException("Out of space!");
        } else {
            this.items[this.counter++] = val;
        }
    }

    /**
     * Important: This delete() only deletes the last entry.
     * @return The deleted entry
     */
    public T delete() throws ListException {
        if (this.counter == 0) {
            throw new ListException("This list is empty!");
        }
        return this.items[this.counter--];
    }

    public String toString() {
        if (counter == 0) {
            return "This list is empty.";
        } else {
            String tmp = "";
            for (int i = 0; i < this.counter; i++) {
                tmp += (this.items[i] + "\n");
            }
            return tmp;
        }
    }

    public void resize() throws ListException {
        try {
            T[] tmp = (T[]) new Object[this.items.length * 2]; // use a resize factor of 2 for greatest efficiency
            System.arraycopy(this.items, 0, tmp, 0, this.items.length - 1);
            this.items = tmp;
        } catch (OutOfMemoryError e) {
            throw new ListException("Error: insufficient memory to allow for resize.");
        }

    }

    /**
     * Insert an item at the nth position
     * @param n the index of insertion (1-based)
     * @param obj
     */
    public void insert(int n, T obj) throws ListException {
        if (obj == null) {
            throw new ListException("Item cannot be null.");
        }
        if (n < 1 || n > this.counter) {
            throw new ListException("Specified index is invalid.");
        }
        if (!checkSpace()) {
            resize();
        }
        for (int i = this.counter - 1; i >= n; i--) {
            this.items[i + 1] = this.items[i];
        }
        this.items[n] = obj;
        this.counter++;
    }

    public T delete(int index) throws ListException {
        if (this.counter == 0) {
            throw new ListException("Cannot delete: empty list.");
        }
        if (index > this.counter) {
            throw new ListException(
                    "Cannot delete: index " + index + " out of bounds for length " + this.counter
            );
        }
        T tmp = this.items[index];
        this.items[index] = null;
        for (int i = index; i < counter; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.counter--;
        return tmp;
    }
}
