package pg.lv0


class PizzaEatTogether {

    fun solution(slice: Int, n: Int): Int {
        return Math.ceil(n / slice.toDouble()).toInt()
    }
}