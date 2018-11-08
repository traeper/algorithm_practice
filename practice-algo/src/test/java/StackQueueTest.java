import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class StackQueueTest {

    @Test
    public void enqueueAndCheckSize() {
        StackQueue<String> sq = new StackQueue<>();
        sq.enqueue("aaa");
        Assert.assertEquals(1, sq.size());
    }

    @Test
    public void enqueueAndDequeue1ea() {
        StackQueue<String> sq = new StackQueue<>();
        sq.enqueue("aaa");
        Assert.assertEquals("aaa", sq.dequeue());
    }

    @Test
    public void enqueueAndDequeue2ea() {
        StackQueue<String> sq = new StackQueue<>();
        sq.enqueue("aaa");
        sq.enqueue("bbb");
        Assert.assertEquals("aaa", sq.dequeue());
        Assert.assertEquals("bbb", sq.dequeue());
    }



}
