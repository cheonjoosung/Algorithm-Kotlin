package pg.lv0

fun main() {
    ChickenCoupon().solution(100).run { println(this) } //11
    ChickenCoupon().solution( 1_081).run { println(this) }//120
}

class ChickenCoupon {

    fun solution(chicken: Int): Int {
        var answer = 0

        var currentCoupon = 0
        var currentChicken = chicken
        while (currentChicken > 0) {
            currentCoupon += currentChicken
            currentChicken = currentCoupon / 10
            answer += currentChicken
            currentCoupon %= 10
        }
        //100 -> 100장이 생기니까 10마리 -> 10장 생기고 1마리 -> 1장 생김
        return answer
    }
}