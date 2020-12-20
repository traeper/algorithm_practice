package algorithm.number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author traeper
 */
public class PrimeNumber {

    /**
     * Simple Ver.
     */
    public static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }

        // O(sqrt(N))
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param num
     * @return false면 소수
     */
    public static boolean[] generateInvertedPrimeNumber(int num) {
        boolean[] inverted = new boolean[num + 1]; // 1 ~ N

        if (num >= 1) {
            inverted[1] = true;
        }

        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (inverted[i]) {
                continue;
            }

            // 에라토스테네스의 체
            // j = i * i 부터 하는 이유는 i보다 작은 값은 이미 걸러져 있기 때문이다.
            for (int j = i * i; j < num; j += i) {
                inverted[j] = true;
            }
        }

        return inverted;
    }

}
