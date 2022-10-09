package pg.lv0

class ClothDiscount {

    fun solution(price: Int): Int {

        return when {
            price in 100_000..299_999 -> (price * 0.95).toInt()
            price in 300_000..499_999 -> (price * 0.9).toInt()
            price >= 500_000 -> (price * 0.8).toInt()
            else -> price
        }
    }
}