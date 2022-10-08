package pg.lv0

class HateEvenNum {

    fun solution(n: Int): IntArray {
        return (1..n).filter { it % 2 == 1 }.toIntArray()
    }
}