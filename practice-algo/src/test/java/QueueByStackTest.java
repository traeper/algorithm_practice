import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class QueueByStackTest {

    @Test
    public void 인큐_디큐_큐_사이즈() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");
        Assert.assertEquals(1, queue.size());

        queue.dequeue();
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void 인큐_디큐1개씩() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");
        Assert.assertEquals("aaa", queue.dequeue());
    }

    @Test
    public void 인큐_디큐2개씩() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        Assert.assertEquals("aaa", queue.dequeue());
        Assert.assertEquals("bbb", queue.dequeue());
    }

    @Test
    public void 인큐_디큐_복잡() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("1");
        queue.enqueue("2");
        Assert.assertEquals("1", queue.dequeue());

        queue.enqueue("3");
        Assert.assertEquals("2", queue.dequeue());

        queue.enqueue("4");
        queue.enqueue("5");
        Assert.assertEquals("3", queue.dequeue());
        Assert.assertEquals("4", queue.dequeue());
        Assert.assertEquals("5", queue.dequeue());
    }

    @Test(expected = EmptyStackException.class)
    public void 디큐_부족한_경우() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("1");
        Assert.assertEquals("1", queue.dequeue());
        queue.dequeue();
    }
}
