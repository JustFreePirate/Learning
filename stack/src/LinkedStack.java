/**
 * Created by dima on 24.08.15.
 */

public class LinkedStack<E> extends AbstractStack<E> {
    private Node<E> head;
//    public static final int AAA;  -- const


    private static class Node<E> { //static дает возможность создавать экземпляры вложенного класса в static методах LinkedStack
        private E value;
        private Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(final E value) {
        head = new Node<E>(value, head);
        size++;
    }

    public E popS() {
        final E value = head.value;
        head = head.next;
        return value;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}
