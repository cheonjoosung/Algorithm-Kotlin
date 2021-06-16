package pg.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ColorBook {

    public static void main(String[] args) {
        ColorBook c = new ColorBook();
        int [][] arr = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int [] ans = c.solution(6, 4, arr);
        System.out.println(ans[0] + " , " + ans[1]);
    }

    public int[] solution(int m, int n, int[][] picture) {

        int[] answer = new int[2];
        boolean [][] visited = new boolean[m][n];


        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {

                if (visited[i][j]) continue;

                visited[i][j] = true;
                bfs(i, j, picture, answer, visited, m, n);
            }
        }

        return answer;
    }

    public void bfs(int x, int y, int [][] arr, int [] answer, boolean [][] visited, int row, int col) {

        int cnt = 1;

        int [] dx = {0, -1, 0, 1};
        int [] dy = {1, 0, -1, 0};

        Queue<CB> q = new LinkedList();
        q.add(new CB(x, y, arr[x][y]));

        while (!q.isEmpty()) {

            CB cb = q.poll();

            for (int d=0 ; d<4 ; d++) {
                int nx = cb.x + dx[d];
                int ny = cb.y + dy[d];

                if (nx<0 || ny<0 || nx>=row || ny>=col) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] != cb.val) continue;

                visited[nx][ny] = true;
                cnt++;
                q.add(new CB(nx, ny, arr[nx][ny]));
            }
        }

        if (arr[x][y] != 0) {
            answer[0]++;
            answer[1] = Math.max(answer[1], cnt);
        }
    }

    class CB {
        int x; int y; int val;
        CB(int x, int y, int val) {
            this.x = x; this.y = y; this.val = val;
        }
    }
}
