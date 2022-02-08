package org.mcdermid;

/**
 * A class to abstract away and manage your LinkedLists.
 * @author Connor McDermid
 */
public class ListManager {

    private Node head;
    private Node tail;

    /**
     * Creates a new, empty LinkedList managed by a new instance of ListManager
     */
    public ListManager() {
        //empty constructor
        head = null;
        tail = null;
    }

    /**
     * Creates a new ListManager to manage an existing LinkedList
     * @param head the head Node of the LinkedList
     * @param tail the tail Node of the LinkedList
     */
    public ListManager(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Gets the head Node in the list
     * @return the head Node
     */
    public Node getHead() {
        return head;
    }

    /**
     * Gets the tail node in the list
     * @return the tail Node
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Redefines the tail Node in the list
     * @param tail the new tail Node
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Adding the first element is a special case
     * @param data Data for the first element
     * @return Pointer to the first element
     */
    private Node addFirstElement(int data) {
        Node tmp = new Node(data, null);
        this.head = tmp;
        this.tail = tmp;
        return this.head;
    }

    /**
     * Add a new node
     * @param data Data for the node
     * @return Pointer to the node
     */
    public Node add(int data) {
        if (this.head == null) {
            //adding first element?
            return addFirstElement(data);
        }
        Node tmp = new Node(data, null);
        this.tail.next = tmp;
        this.tail = this.tail.next;
        return this.tail;
    }

    /**
     * Get node at index
     * @param index index to retrieve
     * @return Node
     */
    public Node getNode(int index) {
        Node cursor = this.head;
        int i = 0;
        while (i != index) {
            if (cursor.next != null) {
                cursor = cursor.next;
                i++;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return cursor;
    }

    /**
     * Get data from node at index
     * @param index index to retrieve
     * @return data to return
     */
    public int get(int index) {
        return getNode(index).data;
    }

    /**
     * Traverses and prints the entire linked list
     */
    public void traverse() {
        Node cursor = this.head;
        while (cursor != null) {
            System.out.println(cursor.data);
            cursor = cursor.next;
        }
    }

    /**
     * Traverses and finds the length of the list
     * @return The length of the list
     */
    public int length() {
        Node cursor = this.head;
        int i = 0;
        while(cursor != null) {
            i++;
            cursor = cursor.next;
        }
        return i;
    }


}
