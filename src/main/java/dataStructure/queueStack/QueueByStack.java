package dataStructure.queueStack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class QueueByStack<T> {

    private final Stack<T> inStack;
    private final Stack<T> outStack;

    public QueueByStack() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(T t) {
        inStack.push(t);
    }

    public T dequeue() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

        try {
            return outStack.pop();
        } catch (EmptyStackException emptyStackException) {
            throw new EmptyQueueException();
        }
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    public boolean contains(T t) {
        return outStack.contains(t) || inStack.contains(t);
    }

}
