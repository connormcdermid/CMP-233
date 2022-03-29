package org.mcdermid;

public interface ListInterface<T> {

    void add(T item) throws ListException;

    void add(T item, int pos) throws ListException;

    T get(int pos) throws ListException;

    void set(T item, int pos) throws ListException;

    int find(T item, int start, int end) throws ListException;

    int size();

    String toString();

    T remove(int pos) throws ListException;

    void clear();

    T[] toArray();

    boolean isEmpty();
}
