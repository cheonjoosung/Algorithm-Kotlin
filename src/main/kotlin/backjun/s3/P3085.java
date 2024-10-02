package backjun.s3;

import java.util.Scanner;

/**
 * S3 사탕게임
 */
public class P3085 {
    static int N;
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            board[i] = row.toCharArray();
        }

        int maxCandy = 0;

        // 사탕 교환 후 최대 연속 사탕 길이 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽과 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1); // 교환
                    maxCandy = Math.max(maxCandy, getMaxCandy());
                    swap(i, j, i, j + 1); // 원래대로 복구
                }

                // 아래쪽과 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j); // 교환
                    maxCandy = Math.max(maxCandy, getMaxCandy());
                    swap(i, j, i + 1, j); // 원래대로 복구
                }
            }
        }

        // 결과 출력
        System.out.println(maxCandy);
    }

    // 두 사탕을 교환하는 함수
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 보드에서 가장 긴 연속된 사탕의 길이를 구하는 함수
    static int getMaxCandy() {
        int maxCandy = 0;

        // 행을 확인
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    maxCandy = Math.max(maxCandy, count);
                    count = 1;
                }
            }
            maxCandy = Math.max(maxCandy, count);
        }

        // 열을 확인
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    maxCandy = Math.max(maxCandy, count);
                    count = 1;
                }
            }
            maxCandy = Math.max(maxCandy, count);
        }

        return maxCandy;
    }
}