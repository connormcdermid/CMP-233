package org.mcdermid;

public interface StackInterface<T> {

    public void push(T obj);

    public T pop() throws ListException;

    public T peek() throws ListException;
}
