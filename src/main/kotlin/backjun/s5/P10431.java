package backjun.s5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * S5 줄세우기
 */
public class P10431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        /**
         * 1. 자신보다 먼저 줄을 선 학생 중 자신보다 키가 큰 학생이 있는지 찾기 없으면 제일 뒤로
         * 2. 자신보다 큰 학생 중 가장 앞에 있는 항생 앞에 선다
         * 3. 나머진 다 뒤로 한칸씩
         */
        int P = sc.nextInt();

        while (P-- > 0) {
            int T = sc.nextInt();
            int[] h = new int[20];

            for (int i = 0; i < 20; i++) {
                h[i] = sc.nextInt();
            }

            int cnt = 0;
            int[] sorted = new int[20];
            for (int i = 0; i < 20; i++) {

                boolean find = false;
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > h[i]) {
                        find = true;
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            cnt++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                }
                if (!find) sorted[i] = h[i];
            }
            System.out.println(T + " " + cnt);
        }
    }
}
