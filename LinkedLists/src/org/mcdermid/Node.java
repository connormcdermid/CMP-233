package org.mcdermid;

/**
 * A node for a singly linked list.
 */
public class Node {

    public Node next;

    public int data;

    /**
     * Constructor for a node in a linked list
     * @param data The data to be stored in the node
     * @param n The next Node in the list
     */
    public Node(int data, Node n) {
        this.next = n;
        this.data = data;
    }
}
