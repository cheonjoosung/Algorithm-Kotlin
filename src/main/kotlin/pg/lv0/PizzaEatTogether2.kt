package pg.lv0

class PizzaEatTogether2 {

    fun solution(array: IntArray, height: Int): Int {
        return array.count { it > height }
    }
}