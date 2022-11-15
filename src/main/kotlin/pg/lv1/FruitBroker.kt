package pg.lv1

fun main() {
    FruitBroker().solution(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)).also { println(it) } //8
    FruitBroker().solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)).also { println(it) } //33

}

class FruitBroker {

    fun solution(k: Int, m: Int, score: IntArray): Int {

        score.sortDescending()

        var index = 0
        var answer = 0

        while(true) {
            if(index >= score.size || index + m > score.size) {
                break;
            }

            answer += score[index + m - 1] * m
            index += m;
        }

        return answer
    }
}