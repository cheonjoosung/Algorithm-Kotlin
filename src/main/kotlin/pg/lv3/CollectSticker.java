package pg.lv3;

public class CollectSticker {

    /**
     * 1. 첫 번째 스티커를 선택하는 경우 → 마지막 스티커는 선택 불가
     * 2. 첫 번째 스티커를 선택하지 않는 경우 → 마지막 스티커는 선택 가능
     * 각 경우에 대해 일반적인 DP 방식(dp[i] = max(dp[i-1], dp[i-2] + sticker[i]))으로
     */
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0]; // 스티커 1개

        // Case 1: 첫 번째 스티커를 사용하는 경우
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0]; // 두 번째는 선택 불가

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // Case 2: 첫 번째 스티커를 사용하지 않는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
