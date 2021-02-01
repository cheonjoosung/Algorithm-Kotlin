package pg.lv1

class DotProduct {
    private fun solution(a: IntArray, b: IntArray) : Int {
        var answer = 0

        for (i in a.indices) {
            answer += a[i] * b[i]
        }

        return answer
        //return a.zip(b).map { it.first * it.second } .sum()
    }
}