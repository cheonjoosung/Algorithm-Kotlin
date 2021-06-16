import backjun.s1.Tomato
import pg.lv1.CountDividor
import pg.lv2.ArrayRotation
import pg.lv3.StarSequence
import pg.lv3.TripRoute

fun main() {

    val c = StarSequence()
    val a1 = intArrayOf(0)
    val a2 = intArrayOf(5, 2, 3, 3, 5 ,3)
    val a3 = intArrayOf(0, 3, 3, 0, 7, 2, 0, 2, 2, 0)
    println(c.solution(a1))
    println(c.solution(a2))
    println(c.solution(a3))
}

