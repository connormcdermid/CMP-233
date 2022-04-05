package org.mcdermid;

import java.util.Objects;

/**
 * A Linked List node for use with {@link org.mcdermid.LList}
 */
public class Node<T> {

    private T value;

    private Node<T> next;

    private Node<T> prev;

    public Node(T obj, Node<T> n, Node<T> p) {
        this.value = obj;
        this.next = n;
        this.prev = p;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != Node.class) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return value.equals(node.value);
    }

    public String toString() {
        return value.toString();
    }
}
