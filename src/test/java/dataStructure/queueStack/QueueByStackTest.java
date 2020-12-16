package dataStructure.queueStack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by jay on 2018. 11. 8.
 **/
public class QueueByStackTest {

    @Test
    public void 인큐_디큐_큐_사이즈() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");

        assertThat(queue.size()).isEqualTo(1);
        queue.dequeue();
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    public void 인큐_디큐1개씩() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");
        assertThat(queue.dequeue()).isEqualTo("aaa");
    }

    @Test
    public void 인큐_디큐2개() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        assertThat(queue.dequeue()).isEqualTo("aaa");
        assertThat(queue.dequeue()).isEqualTo("bbb");
    }

    @Test
    public void 인큐_디큐_복잡() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("1");
        queue.enqueue("2");
        assertThat(queue.dequeue()).isEqualTo("1");
        assertThat(queue.size()).isEqualTo(1);

        queue.enqueue("3");
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.dequeue()).isEqualTo("2");

        queue.enqueue("4");
        queue.enqueue("5");
        assertThat(queue.dequeue()).isEqualTo("3");
        assertThat(queue.dequeue()).isEqualTo("4");
        assertThat(queue.dequeue()).isEqualTo("5");
    }

    @Test
    public void 디큐_부족한_경우() {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("1");
        assertThat(queue.dequeue()).isEqualTo("1");

        assertThrows(EmptyQueueException.class, queue::dequeue);
    }
}
