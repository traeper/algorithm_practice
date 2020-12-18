package algorithm.fibonacci;

/**
 * @author traeper
 */
public class Fibonacci {

    public static int fiboIteration(int n) {
        if (n < 0) {
            throw new RuntimeException();
        }
        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static int fiboRecursive(int n) {
        if (n < 0) {
            throw new RuntimeException();
        }
        int[] memory = new int[n + 2];
        memory[0] = 0;
        memory[1] = 1;

        return fiboInternal(memory, n);
    }

    private static int fiboInternal(int[] memory, int n) {
        if (n == 0 || memory[n] > 0) {
            return memory[n];
        }
        memory[n] = fiboInternal(memory, n - 2) + fiboInternal(memory, n - 1);
        return memory[n];
    }

}
