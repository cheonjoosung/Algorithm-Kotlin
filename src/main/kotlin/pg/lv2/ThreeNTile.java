package pg.lv2;

public class ThreeNTile {

    public int solution(int n) {

        final int MOD = 1_000_000_007;

        if (n % 2 == 1) return 0; // 홀수는 불가능

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        // 3×n 직사각형을 1×2 타일로 채우는 경우의 수는
        // dp[n] = 4 * dp[n - 2] - dp[n - 4] (단, 짝수 n에 대해서만 유효)

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (int)(((4L * dp[i - 2]) % MOD - dp[i - 4] + MOD) % MOD);
        }

        return dp[n];
    }
}
