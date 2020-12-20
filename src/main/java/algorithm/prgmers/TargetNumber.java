package algorithm.prgmers;

/**
 * @author traeper
 */
public class TargetNumber {

    private int answer = 0;

    public int solution(int[] numbers, int target) {
        tn(0, numbers, 0, target);
        return answer;
    }

    private void tn(int sum, int[] numbers, int i, int target) {
        if (numbers.length == i) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        tn(sum + numbers[i], numbers, i + 1, target);
        tn(sum + -numbers[i], numbers, i + 1, target);
    }

}
