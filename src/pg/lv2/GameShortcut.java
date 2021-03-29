package pg.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class GameShortcut {

    public static void main(String[] args) {

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps)); //11
        System.out.println(solution(maps2)); //-1
    }

    public static int solution(int[][] maps) {
        /*
        1. row, col 구하기 -> 도착지점
        2. bfs 탐색
         */

        int row = maps.length;
        int col = maps[0].length;

        boolean[][] isVisited = new boolean[row][col];

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        Queue<P> q = new LinkedList<P>();

        q.add(new P(0, 0, 1));


        while (!q.isEmpty()) {
            P p = q.poll();
            isVisited[p.x][p.y] = true;
            maps[p.x][p.y] = p.move;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                if (maps[nx][ny] == 0) continue;
                if (isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;
                q.add(new P(nx, ny, p.move + 1));
            }
        }


        if (maps[row - 1][col - 1] == 1 || maps[row - 1][col - 1] == 0) {
            return -1;
        } else {
            return maps[row - 1][col - 1];
        }
    }
}

class P {
    int x;
    int y;
    int move;

    P(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}

