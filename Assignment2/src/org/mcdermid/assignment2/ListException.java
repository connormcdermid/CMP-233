package org.mcdermid.assignment2;

/**
 * For use with {@link ListInterface} and relevant classes
 * @author Connor McDermid
 * @see AList
 */
public class ListException extends Exception {

    /**
     * Message to be returned with exception
     */
    private String message;

    /**
     * Set message on throw
     * @param m message
     */
    public ListException(String m) {
        this.message = m;
    }

    /**
     * Returns the message
     * @return message
     */
    public String toString() {
        return message;
    }
}
