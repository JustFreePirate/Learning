package ru.spbu.math.pk.java;

/*
Вопросы:
1) Классы компилируются только в определенном порядке
2) Как сделать сумматор с дженериками
3) как тестить
 */

/**
 * Created by dima on 20.09.15.
 */
public class MyLinkedList<E> implements MyList<E> {
    int size;
    Node<E> head; //ref to begin
    Node<E> tail; //ref to end

    static private class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E value;

        public Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = tail = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Append to the end
    @Override
    public void add(E value) {
        if (tail != null) { //already have elements
            tail.next = new Node<E>(tail,null,value);
            tail = tail.next;
        } else { //this will be the first one
            head = tail = new Node<E>(null, null, value);
        }
        size++;
    }

    //Index = 0...size-1
    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size == 0) { //this will be the first one
                tail = head = new Node<E>(null,null,value);
            } else {
                if (index == size) { //append to the end
                    tail.next = new Node<E>(tail, null, value);
                    tail = tail.next;
                } else {
                    if (index == 0) { //append to the begin
                        head.prev = new Node<E>(null, head, value);
                        head = head.prev;
                    } else {
                        //index = 1..size-1
                        Node<E> current = head;
                        for (int i = 0; i < index; i++) {
                            current = current.next;
                        }
                        // current.prev <new element> current
                        Node<E> newNode = new Node<E>(current.prev, current, value);
                        current.prev.next = newNode;
                        current.prev = newNode;
                    }
                }
            }
        }
        size++;
    }

    //0..size-1
    @Override
    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size == 1) { //case 1 element
                head = tail = null;
            } else {
                if (index == size - 1) { //remove last
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    if (index == 0) { //remove first
                        head = head.next;
                        head.prev = null;
                    } else {
                        //index = 1..size-2
                        Node current = head;
                        for (int i = 0; i < index; i++) {
                            current = current.next;
                        }
                        //current.prev [deleted] current.next
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                }
            }
        }
        size--;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    @Override
    public void map(Function<E> f) {
        if (size != 0) {
            Node<E> current = head;
            f.calculate(head.value);
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
                f.calculate(current.value);
            }
        }
    }

}
