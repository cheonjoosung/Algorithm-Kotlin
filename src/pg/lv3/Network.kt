package pg.lv3

class Network {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        for (arr in computers) {

            var first = -1
            var second = -1

            for (i in arr.indices) {
                if (arr[i] != 0) {
                    if (first != -1) first = i
                    else second = i
                }

                if (second != -1) break
            }


        }

        return answer
    }
}