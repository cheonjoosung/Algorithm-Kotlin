package pg.lv2;

import java.util.*;

public class Oil {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] oilMap = new int[row][col]; // 각 칸이 어떤 oilId에 속하는지 표시
        Map<Integer, Integer> oilSizeMap = new HashMap<>(); // oilId -> 석유 크기
        int oilId = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int size = bfs(i, j, land, visited, oilMap, oilId);
                    oilSizeMap.put(oilId, size);
                    oilId++;
                }
            }
        }

        int answer = 0;

        for (int j = 0; j < col; j++) {
            Set<Integer> colOilIds = new HashSet<>();
            for (int i = 0; i < row; i++) {
                if (oilMap[i][j] > 0) {
                    colOilIds.add(oilMap[i][j]);
                }
            }

            int total = 0;
            for (int id : colOilIds) {
                total += oilSizeMap.get(id);
            }

            answer = Math.max(answer, total);
        }

        return answer;
    }

    private int bfs(int x, int y, int[][] land, boolean[][] visited, int[][] oilMap, int oilId) {
        int count = 1;
        Queue<Po> q = new LinkedList<>();
        q.add(new Po(x, y));
        visited[x][y] = true;
        oilMap[x][y] = oilId;

        while (!q.isEmpty()) {
            Po cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) continue;
                if (visited[nx][ny] || land[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                oilMap[nx][ny] = oilId;
                q.add(new Po(nx, ny));
                count++;
            }
        }

        return count;
    }
}

class Po {
    int x, y;
    Po(int x, int y) {
        this.x = x;
        this.y = y;
    }
}