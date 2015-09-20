package ru.spbu.math.pk.java;

/**
 * Created by dima on 20.09.15.
 */
public class Printer<E> implements Function<E> {
    @Override
    public void calculate(E e) {
        System.out.print(e + " ");
    }
}
