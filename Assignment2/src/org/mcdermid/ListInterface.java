package org.mcdermid;

public interface ListInterface<T> {

    public void add(T item) throws ListException;

    public void add(T item, int pos) throws ListException;

    public T get(int pos) throws ListException;

    public void set(T item, int pos) throws ListException;

    public int find(T item, int start, int end) throws ListException;

    public int size();

    public String toString();

    public T remove(int pos) throws ListException;

    void clear();

    T[] toArray();

    boolean isEmpty();
}
