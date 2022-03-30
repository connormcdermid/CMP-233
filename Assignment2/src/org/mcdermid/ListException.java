package org.mcdermid;

/**
 * For use with {@link org.mcdermid.ListInterface} and relevant classes
 * @author Connor McDermid
 * @see org.mcdermid.AList
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
