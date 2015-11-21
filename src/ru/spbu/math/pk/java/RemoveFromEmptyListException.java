package ru.spbu.math.pk.java;

/**
 * Created by dima on 22.09.15.
 */
public class RemoveFromEmptyListException extends Exception {
    public RemoveFromEmptyListException() {
        //super();
    }

    public RemoveFromEmptyListException(String message) {
        super(message);
    }
}
