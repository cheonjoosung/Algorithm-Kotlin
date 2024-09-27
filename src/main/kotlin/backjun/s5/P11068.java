package backjun.s5;

import java.util.Scanner;

/**
 * S5 회문인 수
 */
public class P11068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        /**
         * 1. 진법 2 ± 64 까지 회문이 가능한가?
         * 2. 64 <= n <= 1_000_000
         */
        int T = sc.nextInt();
        while (T-- >= 0) {
            int n = sc.nextInt();

            boolean isFind = false;
            for (int i=2; i<=64; i++) {
                StringBuilder result = digitTransition(n, i);

                String a = result.toString();
                String b = result.reverse().toString();
                if (a.equals(b)) {
                    isFind = true;
                    break;
                }
            }

            if (isFind) System.out.println("1"); else System.out.println("0");
        }

    }

    public static StringBuilder digitTransition(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while (n >0) {
            int remainder = n % b;

            if (remainder < 10) {
                sb.append((char)('0' + remainder));
            } else {
                sb.append((char)('A' + (remainder - 10)));
            }
            n /= b;
        }

        return sb.reverse();
    }
}
