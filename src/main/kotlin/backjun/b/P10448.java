package backjun.b;

import java.util.Scanner;

/**
 * B1 유레카 이론
 */
public class P10448 {
    static boolean isFind = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        // T1=1, T2=1+2, T3=T2+3
        int[] dp = new int[44 + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 44; i++) {
            dp[i] = dp[i - 1] + i;
        }

        while (tc-- > 0) {
            int total = sc.nextInt();

            isFind = false;
            dfs(dp, 0, 0, total);
            // n이 3개의 삼각수(dp[i] 의 3개)로 표시될 수 있는가?

            if (isFind) System.out.println("1");
            else System.out.println("0");
        }
    }

    private static void dfs(int[] dp, int cnt, int sum, int total) {
        if (cnt == 3) {
            if (sum == total) isFind = true;
            return;
        }

        for (int i = 1; i <= dp.length; i++) {
            if (isFind) break;
            if (sum + dp[i] > total) continue;

            dfs(dp, cnt + 1, sum + dp[i], total);
        }
    }
}
