package pg.lv3;

public class NumberTriangle {
    public int solution(int[][] triangle) {
        // 아래에서부터 위로 DP 누적
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(
                        triangle[i + 1][j],
                        triangle[i + 1][j + 1]
                );
            }
        }
        return triangle[0][0]; // 꼭대기가 최종 최대합
    }
}
