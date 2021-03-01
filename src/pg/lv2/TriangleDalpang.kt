package pg.lv2

class TriangleDalpang {
    fun solution(n: Int): IntArray {
        /*
        아래로 오른쪽 대각선 반복.... d = (1,0) / (0,1) / (-1,-1)
        값이 있거나 존재하지 않는 곳일때 방향 전환
        시작은 1부터 1-1 / 2-3 / 3-6 / 4-10 / 5-15 / 6-21 / 7-28
        숫자는 n*(n+1) / 2 까지
        */

        val endNum = n * (n + 1) / 2
        val dx = intArrayOf(1, 0, -1) //우 상 대각선
        val dy = intArrayOf(0, 1, -1)
        var d = 0 //방향
        var x = 0
        var y = 0

        var answer = IntArray(endNum)
        var arr: Array<IntArray> = Array(n) { IntArray(n) }

        /*
        아래로 갔다가(x+1) 오른쪽으로 갔다가(y+1) 좌상향으로 갔다가(x-1, y-1)
          -1 -1 -1 -1 -1 -1
          -1  1          -1
          -1  2  9       -1
          -1  3 10 8     -1
          -1  4  5 6 7   -1
          -1 -1 -1 -1 -1 -1
         */
        for (i in 1..endNum) {
            arr[x][y] = i

            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) { //외벽인 경우 유턴
                d = (d + 1) % 3
                x += dx[d]
                y += dy[d]
                continue
            }

            if (arr[nx][ny] != 0) { //값이 할당되어있는 경우 방향전환
                d = (d + 1) % 3
                x += dx[d]
                y += dy[d]
                continue
            }

            x = nx
            y = ny
        }

        var idx = 0
        for (tempArr in arr) {
            for (item in tempArr) {
                if (item != 0) answer[idx++] = item
            }
        }

        return answer
    }
}