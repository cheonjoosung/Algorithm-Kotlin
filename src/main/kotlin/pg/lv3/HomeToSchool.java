package pg.lv3;

public class HomeToSchool {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] map = new int[n][m];

        // 웅덩이 표시
        for (int[] puddle : puddles) {
            int x = puddle[1] - 1; // row
            int y = puddle[0] - 1; // col
            map[x][y] = -1;
        }

        // 시작점 초기화
        if (map[0][0] != -1) map[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0; // 갈 수 없는 곳은 0으로 유지
                    continue;
                }

                if (i > 0) {
                    map[i][j] += map[i - 1][j];
                }
                if (j > 0) {
                    map[i][j] += map[i][j - 1];
                }

                map[i][j] %= MOD;
            }
        }

        return map[n - 1][m - 1];
    }
}