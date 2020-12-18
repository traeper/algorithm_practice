package algorithm;

import algorithm.stack.StackBracketFormatter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author traeper
 */
public class StackBracketFormatterTest {

    @Test
    void test_wrong_format1() {
        String s = "{(aabb),(aabc{)}";
        assertThat(StackBracketFormatter.checkBracketFormat(s)).isFalse();
    }

    @Test
    void test_wrong_format2() {
        String s = "{(aabb),(aabc)}{";
        assertThat(StackBracketFormatter.checkBracketFormat(s)).isFalse();
    }

    @Test
    void test_wrong_format3() {
        String s = "{{(aabb),(aabc)}{";
        assertThat(StackBracketFormatter.checkBracketFormat(s)).isFalse();
    }

    @Test
    void test_right_format() {
        String s = "[{(aabb),(aabc)}]";
        assertThat(StackBracketFormatter.checkBracketFormat(s)).isTrue();
    }


}
