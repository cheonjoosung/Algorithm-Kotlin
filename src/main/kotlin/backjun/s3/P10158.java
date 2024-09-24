package backjun.s3;

import java.util.Scanner;

/**
 * S3 개미
 */
public class P10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**
         * 해결 전략
         * 1. 개미가 t시간 후 위치는 (p + t, q + t)입니다.
         * 이 값을 w와 h에 대해 모듈로 연산을 적용해 좌표를 계산합니다.
         * 2. 개미가 좌우 경계를 넘을 때마다 방향이 바뀝니다.
         * 예를 들어, p+t를 w로 나누었을 때의 몫이 짝수이면 오른쪽으로 이동 중이고, 홀수이면 왼쪽으로 이동 중입니다.
         * 3. 마찬가지로 q+t를 h로 나누었을 때도 위쪽이나 아래쪽으로 이동하는지를 알 수 있습니다.
         */
        // 입력 받기
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        // 가로 좌표 계산
        int x = (p + t) % (2 * w);
        if (x > w) {
            x = 2 * w - x;
        }

        // 세로 좌표 계산
        int y = (q + t) % (2 * h);
        if (y > h) {
            y = 2 * h - y;
        }

        // 결과 출력
        System.out.println(x + " " + y);
    }
}
