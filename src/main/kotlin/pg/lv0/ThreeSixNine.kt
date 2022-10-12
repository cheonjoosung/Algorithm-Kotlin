package pg.lv0

class ThreeSixNine {

    fun solution(order: Int): Int {
        return order.toString().filter { it == '3' || it =='6' || it =='9' }.count()
    }
}