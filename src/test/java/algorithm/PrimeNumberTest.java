package algorithm;

import algorithm.number.PrimeNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author traeper
 */
public class PrimeNumberTest {

    @Test
    void primeNumberTest() {
        assertThat(PrimeNumber.isPrimeNumber(1)).isFalse();
        assertThat(PrimeNumber.isPrimeNumber(2)).isTrue();
        assertThat(PrimeNumber.isPrimeNumber(3)).isTrue();
        assertThat(PrimeNumber.isPrimeNumber(4)).isFalse();
        assertThat(PrimeNumber.isPrimeNumber(5)).isTrue();
        assertThat(PrimeNumber.isPrimeNumber(6)).isFalse();
        assertThat(PrimeNumber.isPrimeNumber(7)).isTrue();
        assertThat(PrimeNumber.isPrimeNumber(8)).isFalse();
    }

    @Test
    void printPrimeNumber() {
        boolean[] inverted = PrimeNumber.generateInvertedPrimeNumber(100);
        for (int i = 1; i < 100; i++) {
            System.out.printf("%d[%b]\t", i, !inverted[i]);
            if (i % 5 == 0) {
                System.out.println();
            }
        }

    }
}
