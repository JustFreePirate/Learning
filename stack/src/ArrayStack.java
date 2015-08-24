/**
 * Created by dima on 24.08.15.
 */

public class ArrayStack<E> extends AbstractStack<E> {
    private E[] elements;

    public ArrayStack() {
        //super(...) конструктор предка
        this(10); // конструктор себя
    }

    public ArrayStack(int capacity) {
        elements = (E[]) (new Object[capacity]); // приведение к E[], т.к. в generic нельзя узнать что за тип E
    }

    public void push(E value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    public void ensureCapacity(int capacity) {
        if (elements.length >= capacity) {
            return;
        }
        E[] newElements = (E[]) (new Object[capacity * 2]);
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public E popS() {
        return elements[size];
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }
}
