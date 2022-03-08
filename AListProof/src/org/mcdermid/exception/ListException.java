package org.mcdermid.exception;

public class ListException extends Exception {
    private String message;

    public ListException(String s) {
        this.message = s;
    }

    public String toString() {
        return message;
    }
}
