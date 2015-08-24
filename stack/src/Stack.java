/**
 * Created by dima on 24.08.15.
 */
public interface Stack<E> {
    void push(E element);
    E pop();
    E peek();
    E top();
    int size();
    boolean isEmpty();
}
