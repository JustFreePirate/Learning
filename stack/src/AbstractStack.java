/**
 * Created by dima on 24.08.15.
 */
public abstract class AbstractStack<E> implements Stack<E> {
    protected int size;

    public final boolean isEmpty() {
        return size == 0;
    }

    public final int size() {
        return size;
    }

    public E pop() {
        if (size == 0) {
            return null;
        }
        size--;
        return popS();
    }

    protected abstract E popS();

    public E top() {
        return peek();
    }

    /* public abstract E peek(); */
}
