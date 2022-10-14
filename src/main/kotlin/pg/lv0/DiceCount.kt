package pg.lv0

class DiceCount {

    fun solution(box: IntArray, n: Int): Int {
        return (box[0] / n) * (box[1] / n) * (box[2] / n)
    }
}