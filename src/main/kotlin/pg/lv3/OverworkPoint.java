package pg.lv3;

import java.util.*;

public class OverworkPoint {

    public long solution(int n, int[] works) {
        // Max Heap을 위한 PriorityQueue (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 작업량들을 우선순위 큐에 넣기
        for (int work : works) {
            pq.offer(work);
        }

        // N 시간 동안 가장 큰 작업부터 하나씩 줄이기
        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if (max > 0) {
                pq.offer(max - 1);
            }
            n--;
        }

        // 남은 작업들의 제곱합 계산 (야근 피로도)
        long result = 0;
        while (!pq.isEmpty()) {
            int remain = pq.poll();
            result += (long) remain * remain;
        }

        return result;
    }
}
