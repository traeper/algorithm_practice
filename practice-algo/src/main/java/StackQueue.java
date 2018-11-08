import java.util.Stack;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class StackQueue<T> {

    private Stack<T> inStack;
//    private Stack<T> inStack;

    public StackQueue() {
        inStack = new Stack<>();
    }

    public void enqueue(T t) {
        inStack.push(t);
    }

    public T dequeue() {
        return inStack.pop();
    }


    public int size() {
        return inStack.size();
    }
}
