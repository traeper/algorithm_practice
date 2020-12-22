package algorithm.basic;

/**
 * @author traeper
 * <p>
 * Q) 크기가 n(n>5) 인 배열이 주어집니다.
 * 이 배열은 등차가 1보다 크거나 같은 등차 수열을 이루고 있습니다. (n = ad, a >= 1)
 * 이 배열에서 중간에 있는 수 하나를 제거합니다. 이를 brr이라 합시다. 배열 brr의 크기는 n-1일겁니다.
 * input으로 배열 brr과 brr의 크기가 주어집니다. 이 때 빠진 수를 어떻게 빠르게 찾을 수 있을까요?
 */
public class Quest3 {

    /**
     * 0. 등차를 파악합니다.(연속된 요소 3그룹의 등차를 확인하여 그 중 2개 이상의 등차가 되는 것을 실 등차로 판명)
     * 1. 먼저 배열의 가운데 인덱스로 배열을 쪼갭니다.
     * 2. 쪼개진 배열마다 (끝점 - 시작점) 값을 구합니다. (배열 크기는 기본적으로 구해짐)
     * 3. 끝점 - 시작점이 등차수열 합과 맞지 않다면 그 부분으로 파고 들어가면서 2번의 동작을 반복합니다.
     * 그 외의 배열은 더는 처리하지 않아도 될 것 같습니다.
     *
     * @return 빠진 수
     */
    public static int findMissingOne(int[] n) {
        if (n.length <= 5) {
            throw new RuntimeException();
        }

        // 0 등차 파악
        int diff1 = n[1] - n[0];
        int diff2 = n[2] - n[1];

        int decidedDiff = Math.min(diff1, diff2);

        return findInternal(n, 0, n.length - 1, decidedDiff);
    }

    /**
     * 시간복잡도 O(logN)
     */
    private static int findInternal(int[] n, int s, int e, int decidedDiff) {
        // 배열의 크기가 짝수가 될 때까지 줄여야 할 것 같고 홀수인
        // 두 개의 차가 등차의 2배가 된다면 그 두 개의 값으로 나눗셈을 구할 수 있습니다.
        // 종료 지점
        if (e - s <= 1) {
            return (n[e] + n[s]) / 2;
        }

        int mid = (s + e) / 2;
        int leftDiff = n[mid] - n[s]; // 좌측 시작 끝차
        int lefts = mid - s + 1; // 갯수

        if (leftDiff / (lefts - 1.0) > decidedDiff) { // 좌측 이상 유무 판명
            return findInternal(n, s, (s + e) / 2, decidedDiff);
        } else if (n[mid + 1] - n[mid] == decidedDiff * 2) { // 경계 간 비교
            return (n[mid + 1] + n[mid]) / 2;
        } else {
            return findInternal(n, mid + 1, e, decidedDiff);
        }
    }
}
