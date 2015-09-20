package ru.spbu.math.pk.java;




/**
 * Created by dima on 20.09.15.
 */
public interface MyList<E> {
    int size();
    boolean isEmpty();
    void add(E e);
    void add(int index, E e);
    void remove(int index);
    void clear();
    E get(int index);
    void set(int index, E element);
    void map(Function<E> f);
}
