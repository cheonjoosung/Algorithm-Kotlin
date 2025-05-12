package pg.lv3;

import java.util.*;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); // A팀 순서 고정이지만 정렬해도 상관 없음 (매칭 기준으로만 사용)
        Arrays.sort(B); // B팀은 전략적으로 순서를 조정 가능

        int a = 0;
        int b = 0;
        int score = 0;

        // 두 배열을 순회하며 최적의 매칭 탐색
        while (a < A.length && b < B.length) {
            if (B[b] > A[a]) {
                // B팀이 이길 수 있는 가장 작은 수로 승리
                score++;
                a++;
                b++;
            } else {
                // B팀이 A팀보다 작거나 같으면 버리고 다음 B팀 수로 시도
                b++;
            }
        }

        return score;
    }
}
