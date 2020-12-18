package algorithm.level1;

/**
 * @author traeper
 * for문을 거꾸로 하는 단순한 알고리즘이지만 문제로 나온다면 제약조건 확인은 필요할듯 하다.
 * 1. StringBuilder를 쓰지 않고 구현해야 한다면 char 배열로 직접 구현해야 한다.(StringBuilder 내부 구현은 char 배열로 구현되어 있음.)
 */
public class StringReverse {

    public static String reverse(String s) {
        char[] chars = s.toCharArray();

        // 문자열 변경이 잦고 성능을 올리기 위해 StringBuilder를 사용한다.
        StringBuilder sb = new StringBuilder(chars.length);

        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

}
