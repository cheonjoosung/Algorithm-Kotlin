package backjun.s4;

import java.util.Scanner;

/**
 * S4 행운의바퀴
 */

public class P2817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 바퀴 칸의 수
        int K = sc.nextInt();  // 회전 횟수

        char[] wheel = new char[N];  // 바퀴에 적힌 문자
        boolean[] used = new boolean[26];  // 알파벳이 이미 사용되었는지 확인하는 배열
        int currentPosition = 0;  // 현재 화살표가 가리키는 위치

        // 바퀴의 칸을 '?'로 초기화
        for (int i = 0; i < N; i++) {
            wheel[i] = '?';
        }

        boolean isValid = true;  // 행운의 바퀴가 가능한지 여부

        // 회전 정보를 처리
        for (int i = 0; i < K; i++) {
            int S = sc.nextInt();  // 몇 칸 회전했는지
            char letter = sc.next().charAt(0);  // 멈췄을 때의 글자

            // 현재 위치에서 S만큼 시계 반대 방향으로 돌아가서 새로운 위치를 찾음
            currentPosition = (currentPosition - S % N + N) % N;

            // 해당 위치가 이미 다른 글자로 채워져 있다면
            if (wheel[currentPosition] != '?' && wheel[currentPosition] != letter) {
                isValid = false;  // 충돌 발생
                break;
            }

            // 이미 사용된 알파벳이면
            if (wheel[currentPosition] == '?' && used[letter - 'A']) {
                isValid = false;  // 중복 발생
                break;
            }

            // 해당 위치에 글자 배치
            wheel[currentPosition] = letter;
            used[letter - 'A'] = true;  // 해당 글자 사용됨
        }

        if (isValid) {
            // 결과 출력
            for (char c : wheel) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            System.out.println("!");
        }
    }
}
