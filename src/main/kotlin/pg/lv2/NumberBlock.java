package pg.lv2;

public class NumberBlock {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            long num = begin + i;

            if (num == 1) {
                answer[i] = 0;
                continue;
            }

            // 가장 큰 약수를 찾기 위해 √num 까지만 탐색
            int maxBlock = 1;
            for (long j = 2; j * j <= num && j <= 10000000; j++) {
                if (num % j == 0) {
                    long pair = num / j;

                    if (pair <= 10000000) {
                        maxBlock = (int)pair;
                        break; // 큰 쪽 약수를 먼저 찾았으니 break
                    } else if (j <= 10000000) {
                        maxBlock = (int)j;
                    }
                }
            }

            answer[i] = maxBlock;
        }

        return answer;
    }

}
