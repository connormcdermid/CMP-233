package org.mcdermid;

public class Stack<T> implements StackInterface<T> {

    private Node<T> head; // this internally uses an LList, but it doesn't need a tail.
                            // because stacks are LIFO

    // private int counter; // shouldn't need a counter

    public Stack(Node<T> h) {
        this.head = h;
    }

    public Stack(T obj) {
        this.head = new Node<>(obj, null, null);
    }

    public Stack() {
        this.head = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void push(T obj) {
        if (this.head == null) {
            this.head = new Node<>(obj, null, null);
        } else {
            Node<T> newnode = new Node<>(obj, this.head, null);
            this.head.setPrev(newnode);
            this.head = newnode;
        }
    }

    public T pop() throws ListException {
        if (this.head == null) {
            throw new ListException("This list is empty.");
        }
        T ret = this.head.getValue();
        this.head = this.head.getNext();
        return ret;
    }

    public T peek() {
        return this.head == null ? null : this.head.getValue();
    }
}
