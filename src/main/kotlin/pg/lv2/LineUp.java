package pg.lv2;

import java.util.ArrayList;

public class LineUp {

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
}
