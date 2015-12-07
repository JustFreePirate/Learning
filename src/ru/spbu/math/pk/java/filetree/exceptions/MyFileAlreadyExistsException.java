package ru.spbu.math.pk.java.filetree.exceptions;

/**
 * Created by dima on 24.11.15.
 */
public class MyFileAlreadyExistsException extends Exception {
    public MyFileAlreadyExistsException() {
        super();
    }

    public MyFileAlreadyExistsException(String message) {
        super(message);
    }

    public MyFileAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFileAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected MyFileAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
