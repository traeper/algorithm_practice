package algorithm.basic;

import java.util.Random;

/**
 * @author traeper
 * Q. 광고배너를 광고료에 따라 노출비중을 다르게 하려고 합니다.
 * 하나의 광고영역에 A, B, C 세 종의 광고배너를 60%, 30%, 10% 비율로 노출하는 함수를 작성해주세요.
 */
public class Quest2 {

    public static int generateBannerIndex() {
        // 1. 노출 통계 분석

        // 2. 10%가 달성이 안됐을 시 가중치 상승, 초과했다면 가중치 하락
        Random rand = new Random();
        return rand.nextInt(10) % 10;
    }

    /**
     * @return bannerId
     */
    public static String exposeBanner(int bannerIndex) {
        if (bannerIndex <= 5) {
            return "A";
        } else if (bannerIndex <= 8) {
            return "B";
        }

        return "C";
    }
}
