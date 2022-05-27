package pg.lv1

class CalculatorAmount {

        fun solution(price: Int, money: Int, count: Int): Long {
            val res = money.toLong() - price * (1..count).sum().toLong()
            return if (res > 0) 0 else Math.abs(res)
    }
}