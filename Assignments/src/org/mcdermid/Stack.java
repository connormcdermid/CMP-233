package org.mcdermid;

/**
 * An implementation of a Stack with an internal partial singly-linked list.
 * @param <T> The type of object the Stack should contain
 */
public class Stack<T> implements StackInterface<T> {

    private Node<T> head; // this internally uses an LList, but it doesn't need a tail.
                            // because stacks are LIFO

    // private int counter; // shouldn't need a counter

    /**
     * Constructs a new Stack with the first element set by a Node input
     * @param h First Node of the stack
     */
    public Stack(Node<T> h) {
        this.head = h;
    }

    /**
     * Constructs a new Stack with an element
     * @param obj First element of the stack
     */
    public Stack(T obj) {
        this.head = new Node<>(obj, null, null);
    }

    /**
     * Constructs an empty Stack
     */
    public Stack() {
        this.head = null;
    }

    /**
     * Returns the head element of the Stack
     * @return
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * Pushes an item onto the stack.
     * @param obj Item to push on to the stack
     */
    public void push(T obj) {
        if (this.head == null) {
            this.head = new Node<>(obj, null, null);
        } else {
            Node<T> newnode = new Node<>(obj, this.head, null);
            this.head.setPrev(newnode);
            this.head = newnode;
        }
    }

    /**
     * Pops an item from the top of the stack
     * @return The item popped from the stack
     * @throws ListException Thrown if the stack is empty
     */
    public T pop() throws ListException {
        if (this.head == null) {
            throw new ListException("This stack is empty.");
        }
        T ret = this.head.getValue();
        this.head = this.head.getNext();
        return ret;
    }

    /**
     * Allows you to view the top element of the stack without popping it.
     * @return The top element of the stack -- null if empty.
     */
    public T peek() {
        return this.head == null ? null : this.head.getValue();
    }

    /**
     * toString
     * @return toString
     */
    public String toString() {
        return this.head.toString();
    }
}
