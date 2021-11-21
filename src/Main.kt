import pg.lv1.MinimumRectangular
import pg.lv2.CutNArray
import pg.lv3.EditPyo

fun main() {

    val a1 = arrayOf(intArrayOf(60, 50), intArrayOf(30, 70), intArrayOf(60, 30), intArrayOf(80, 40))

    val s = CutNArray()
    println(s.solution(3, 2, 5))
    println(s.solution(4, 7, 14))
}


