package org.mcdermid.interfaces;

import org.mcdermid.exception.ListException;

public interface ListInterface<T> {

    public void add(T x) throws ListException;

    public T delete() throws ListException;

    public void insert(int n, T obj) throws ListException;
}
