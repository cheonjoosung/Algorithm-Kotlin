package backjun.b;

import java.util.Scanner;

/**
 * B1 진법 변환2
 */
public class P11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

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

        System.out.println(sb.reverse());
        sc.close();
    }
}
