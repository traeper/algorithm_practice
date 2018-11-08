import java.util.Stack;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class QueueByStack<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;

    public QueueByStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(T t) {
        inStack.push(t);
    }

    public T dequeue() {
        if(outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }


    public int size() {
        return inStack.size();
    }
}
