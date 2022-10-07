package pg.lv0

class IceAmericano {

    fun solution(money: Int): IntArray {
        return intArrayOf(money / 5500, money % 5500)
    }
}