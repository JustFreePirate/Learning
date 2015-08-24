/**
 * Created by dima on 24.08.15.
 */
public class StackTest {
    public static void fill(Stack<String> stack) {
        for (int i = 0; i < 5; i++) {
            stack.push("str"+i);
        }
    }
    public static<E> void dump(Stack<E> stack) {
        System.out.println(stack.size());
        while (stack.size() > 0) {
            System.out.println(stack.peek() + " " + stack.pop());
        }
    }
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>();
        fill(stack);
        dump(stack);
        LinkedStack<String> stack2 = new LinkedStack<String>();
        fill(stack2);
        dump(stack2);
    }
}