package algorithm;

import algorithm.fibonacci.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author traeper
 */
public class FibonacciTest {

    @Test
    void fiboRecursive() {
        assertThat(fiboRecursive(0)).isEqualTo(0);
        assertThat(fiboRecursive(1)).isEqualTo(1);
        assertThat(fiboRecursive(2)).isEqualTo(1);
        assertThat(fiboRecursive(3)).isEqualTo(2);
        assertThat(fiboRecursive(4)).isEqualTo(3);
        assertThat(fiboRecursive(5)).isEqualTo(5);
        assertThat(fiboRecursive(6)).isEqualTo(8);
        assertThat(fiboRecursive(7)).isEqualTo(13);
    }

    private int fiboRecursive(int n) {
        return Fibonacci.fiboRecursive(n);
    }

    @Test
    void fiboIteration() {
        assertThat(fiboIteration(0)).isEqualTo(0);
        assertThat(fiboIteration(1)).isEqualTo(1);
        assertThat(fiboIteration(2)).isEqualTo(1);
        assertThat(fiboIteration(3)).isEqualTo(2);
        assertThat(fiboIteration(4)).isEqualTo(3);
        assertThat(fiboIteration(5)).isEqualTo(5);
        assertThat(fiboIteration(6)).isEqualTo(8);
        assertThat(fiboIteration(7)).isEqualTo(13);
    }

    private int fiboIteration(int n) {
        return Fibonacci.fiboIteration(n);
    }
}
