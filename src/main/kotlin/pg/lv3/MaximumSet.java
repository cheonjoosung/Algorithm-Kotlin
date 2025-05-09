package pg.lv3;

import java.util.Arrays;

public class MaximumSet {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] result = new int[n];
        int base = s / n;
        int remainder = s % n;

        // 기본값 채우기
        Arrays.fill(result, base);

        // 나머지 만큼 뒤에서부터 +1씩 추가 (오름차순 결과 유도)
        for (int i = n - 1; i >= n - remainder; i--) {
            result[i]++;
        }

        return result;
    }
}
