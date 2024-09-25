package backjun.b;

import java.util.Scanner;

/**
 * B1 성지키기
 */
public class P1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = sc.next();
            map[i] = line.toCharArray();
        }
        int rowGuard = 0;
        int colGuard = 0;

        for (int i = 0; i < row; i++) {
            boolean hasGuard = false;
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'X') {
                    hasGuard = true;
                    break;
                }
            }

            if (!hasGuard) rowGuard++;
        }

        for (int i = 0; i < col; i++) {
            boolean hasGuard = false;
            for (int j = 0; j < row; j++) {
                if (map[j][i] == 'X') {
                    hasGuard = true;
                    break;
                }
            }

            if (!hasGuard) colGuard++;
        }

        System.out.println(Math.max(rowGuard, colGuard));
    }
}
