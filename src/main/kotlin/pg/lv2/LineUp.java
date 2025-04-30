package pg.lv2;

import java.util.ArrayList;

public class LineUp {

    /**
     * ✍️ 개념 설명
     * - 팩토리얼(factorial)	자리수당 가능한 경우의 수를 계산
     * - k값 업데이트	각 단계에서 나머지를 통해 다음 k를 결정
     * - index 계산	k / (n-1)!을 통해 어떤 숫자가 와야 하는지 파악
     *
     * ✍️ 수식 요약
     * - 첫 번째 숫자 인덱스 = k / (n-1)!
     * - 다음 k = k % (n-1)!
     * - 반복하면서 n--, 리스트에서 숫자 제거
     *
     */
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        k--; // 0-based index로 변환

        for (int i = 0; i < n; i++) {
            fact = fact / (n - i);
            int index = (int)(k / fact);
            answer[i] = nums.get(index);
            nums.remove(index);
            k = k % fact;
        }

        return answer;
    }
    /*
    1단계: fact = 4! = 24 (전체 순열 수)
    2단계: 첫 번째 자리에 올 숫자 결정
        fact = 24, 자리수 기준으로 나누면 fact / 4 = 6
        가능한 숫자: [1, 2, 3, 4]
        k = 14 → 0-based로 k-1 = 13
        index = 13 / 6 = 2 → 세 번째 수 = 3
        순열의 첫 숫자: 3
        nums = [1, 2, 4], k = 13 % 6 = 1

    3단계: 두 번째 자리
        남은 숫자 3개 → fact = 6, fact / 3 = 2
        index = 1 / 2 = 0 → 첫 번째 수 = 1
        순열의 두 번째 숫자: 1
        nums = [2, 4], k = 1 % 2 = 1

    4단계: 세 번째 자리
        남은 숫자 2개 → fact = 2, fact / 2 = 1
        index = 1 / 1 = 1 → 두 번째 수 = 4
        순열의 세 번째 숫자: 4
        nums = [2], k = 0

    5단계: 마지막 숫자
        남은 숫자: 2

    결과: 3 1 4 2
     */
}
