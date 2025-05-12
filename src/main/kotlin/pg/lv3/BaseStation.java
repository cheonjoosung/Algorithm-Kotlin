package pg.lv3;

import java.util.*;

public class BaseStation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = w*2 + 1;
        int start = 1;

        for (int station : stations) {
            int left = station - w;

            if (start < left) {
                int gap = left - start;
                answer += Math.ceil((double) gap / coverage);
            }
            start = station + w + 1;
        }

        // 마지막 기지국 이후 커버되지 않은 구간
        if (start <= n) {
            int gap = n - start + 1;
            answer += Math.ceil((double) gap / coverage);
        }

        return answer;
    }

}
