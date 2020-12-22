package algorithm.basic;

/**
 * @author traeper
 * <p>
 * <p>
 * Q> a = b + 1과 같이 assign은 허용이 되지만,
 * 한번 a에 값이 assign 되면 a는 다른 값으로 바꿀 수 없는 언어가 있습니다.
 * <p>
 * 임의의 정수 N부터 M까지 더하는 프로그램을 작성해주세요.
 */
public class Quest {

    public static int sum(int N, int M) {
        return sumInternal(N, M);
    }

    private static int sumInternal(int current, int to) {
        if (current == to) {
            return current;
        }

        return current + sumInternal(current + 1, to);
    }

}
