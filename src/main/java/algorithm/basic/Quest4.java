package algorithm.basic;

import java.util.Stack;

/**
 * @author traeper
 * <p>
 * 1. 코딩 테스트 단어에 나오는 모음의 순서를 바꾸는 함수를 코딩해보세요.
 * ex) hello -> holle
 * naver webtoon => novor webtean
 * <p>
 * 2. 정해진 수만큼 숫자들을 지그재그 ㄹ자로 출력하는 메소드를 작성해보세요.
 * <p>
 * - 예) 차수 : 7
 * 1 2 3 4 5 6 7
 * 14 13 12 11 10 9 8
 * 15 16 17 18 19 20 21
 */
public class Quest4 {

    public static char[] reverseVowel(char[] string) {
        // stack
        Stack<Character> stack = new Stack<>();

        // 모음 식별 기능
        for (int i = 0; i < string.length; i++) {
            // 모음 체크 ( 생략 )
            if (isVowel(string[i])) {
                stack.push(string[i]);
            }
        }

        for (int i = 0; i < string.length; i++) {
            // 모음일 때마다
            if (isVowel(string[i])) {
                string[i] = stack.pop();
            }

        }

        return string;
    }

    static char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};

    private static boolean isVowel(char c) {
        for (char value : vowel) {
            if (value == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 2. 정해진 수만큼 숫자들을 지그재그 ㄹ자로 출력하는 메소드를 작성해보세요.
     * <p>
     * - 예) 차수 : 7
     * 1 2 3 4 5 6 7
     * 14 13 12 11 10 9 8
     * 15 16 17 18 19 20 21
     */
    public static void solution2(int num, int input) {
        for (int i = 1; i <= num; i++) {
            // 역방향인 경우; 차수를 짝수로 나눠서 떨어지는 부분에서 범위를 줘야합니다.
            // 1 ~ input
            // input+1 ~ 2input
            // 2input+1 ~ 3input
            int a = (i - 1) / input; // 몫
            if (((i - 1) / input) % 2 == 0) {
                System.out.printf("%d ", i);
            } else {
                System.out.printf("%d ", input * (a + 2) - i + 1);
            }

            // 줄바꿈
            if (i % input == 0) {
                System.out.println();
            }
        }

    }

}
