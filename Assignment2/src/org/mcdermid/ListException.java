package org.mcdermid;

public class ListException extends Exception {

    private String message;

    public ListException(String m) {
        this.message = m;
    }

    public String toString() {
        return message;
    }
}
