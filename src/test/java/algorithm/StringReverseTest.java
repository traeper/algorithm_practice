package algorithm;

import algorithm.level1.StringReverse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author traeper
 */
public class StringReverseTest {

    @Test
    void reverse() {
        String input = "abcdefg";
        assertThat(StringReverse.reverse(input)).isEqualTo("gfedcba");
    }
}
