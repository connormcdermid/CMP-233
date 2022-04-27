package org.mcdermid;

public class Stack<T> implements StackInterface<T> {

    private LList<T> items;


    /**
     * Constructor to make a Stack already populated with items
     * @param objs An LList of type T items
     */
    public Stack(LList<T> objs) {
        this.items = objs;
    }

    /**
     * Constructor to initialise your Stack with one value.
     * @param obj One object of type T
     */
    public Stack(T obj) {
        this.items = new LList<>(obj);
    }

    /**
     * Default constructor to initialise an empty Stack.
     */
    public Stack() {
        this.items = new LList<>();
    }

    /**
     * Push an item on to the stack.
     * @param obj One object of type T to be pushed to the stack
     */
    public void push(T obj) {
        if (this.items.getHead() != null) {
            Node<T> newNode = new Node<>(obj, this.items.getHead(), null);
            this.items.getHead().setPrev(newNode);
            this.items.setHead(newNode);
        } else {
            this.items.setHead(new Node<>(obj, null, null));
        }
    }

    /**
     * Pops an item from the stack.
     * @return The popped item
     */
    public T pop() throws ListException {
        if (this.items.getHead() == null) {
            throw new ListException("you fool, you absolute buffoon, there aren't any elements in this stack.");
        }
        T ret = this.items.getHead().getValue();
        this.items.setHead(this.items.getHead().getNext());
        this.items.getHead().setPrev(null);
        return ret;
    }

    public T peek() throws ListException {
        try {
            return this.items.get(1);
        } catch(ListException e) {
            throw new ListException("you fool, you absolute buffoon, there aren't any elements in this stack.");
        }
    }
}
