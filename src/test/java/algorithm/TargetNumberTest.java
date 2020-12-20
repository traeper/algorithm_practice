package algorithm;

import algorithm.prgmers.TargetNumber;
import org.junit.jupiter.api.Test;

/**
 * @author traeper
 */
public class TargetNumberTest {

    @Test
    void name() {
        int[] numbers = {1, 1, 1, 1, 1};
        int answer = new TargetNumber().solution(numbers, 3);
        System.out.println(answer);
    }

    @Test
    void bb() {
        int[] numbers = {1, 2, 3, 4, 5};
        int answer = new TargetNumber().solution(numbers, 3);
        System.out.println(answer);
    }
}
