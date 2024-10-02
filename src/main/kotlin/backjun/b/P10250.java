package backjun.b;

import java.util.Scanner;

/**
 * B3 ACM 호텔
 */
public class P10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int h = sc.nextInt(); // 호텔층
            int w = sc.nextInt(); // 방수
            int n = sc.nextInt(); // 몇 번째 손님

            // N 번째 손님에게 배정되어야하는 호수
            int floor = n%h;
            int room = (n/h) + 1;

            // 만약 N이 H의 배수라면, 최상층에 배정해야 하므로 예외 처리
            if (floor == 0) {
                floor = h;
                room -= 1;
            }

            // 결과 출력 (층수와 호수를 합쳐 출력)
            System.out.printf("%d%02d\n", floor, room);
        }
    }
}
