package algorithm;

import algorithm.basic.Quest;
import algorithm.basic.Quest2;
import algorithm.basic.Quest3;
import algorithm.basic.Quest4;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author traeper
 */
public class QuestTest {

    @Test
    void algoTest() {
        // 3,4,5
        int sum = Quest.sum(3, 5);
        assertThat(sum).isEqualTo(12);

        // 3,4,5,6,7 =
        int sum2 = Quest.sum(3, 7);
        assertThat(sum2).isEqualTo(25);
    }

    @Test
    void generateBannerByExposalRule() {
        exposeBanner(0, "A");
        exposeBanner(1, "A");
        exposeBanner(2, "A");
        exposeBanner(3, "A");
        exposeBanner(4, "A");
        exposeBanner(5, "A");
        exposeBanner(6, "B");
        exposeBanner(7, "B");
        exposeBanner(8, "B");
        exposeBanner(9, "C");
    }

    private void exposeBanner(int i, String a) {
        assertThat(Quest2.exposeBanner(i)).isEqualTo(a);
    }

    @Test
    void findMissingOne() {
        int[] arr = new int[]{1, 3, 5, 7, 11, 13, 15};
        findMissingOneTest(arr, 9);

        int[] arr2 = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 19};
        findMissingOneTest(arr2, 17);

        int[] arr3 = new int[]{1, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25};
        findMissingOneTest(arr3, 3);

        int[] arr4 = new int[]{1, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23};
        findMissingOneTest(arr4, 3);

        int[] arr5 = new int[]{1, 3, 5, 7, 9, 11, 13, 17, 19, 21, 23};
        findMissingOneTest(arr5, 15);
    }

    private void findMissingOneTest(int[] arr, int expected) {
        assertThat(Quest3.findMissingOne(arr)).isEqualTo(expected);
    }

    @Test
    void vowelReverse() {
        vr("naver webtoon", "novor webtean");
        vr("aeiou", "uoiea");
    }

    private void vr(String source, String result) {
        String reversed = new String(Quest4.reverseVowel(source.toCharArray()));
        assertThat(reversed).isEqualTo(result);
    }

    @Test
    void zigzagPrint() {
        Quest4.solution2(21, 7);
        System.out.println();
        Quest4.solution2(24, 8);
        System.out.println();
    }
}
