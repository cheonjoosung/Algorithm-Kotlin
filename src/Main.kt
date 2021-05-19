import pg.lv2.ArrayRotation
import pg.lv3.TripRoute

fun main() {

    val b = ArrayRotation()
    val a1 = arrayOf(
        intArrayOf(2, 2, 5, 4),
        intArrayOf(3, 3, 6, 6),
        intArrayOf(5, 1, 6, 3)
    )

    val a2 = arrayOf(
        intArrayOf(1, 1, 2, 2),
        intArrayOf(1, 2, 2, 3),
        intArrayOf(2, 1, 3, 2),
        intArrayOf(2, 2, 3, 3)
    )

    val a3 = arrayOf(
        intArrayOf(1, 1, 100, 97)
    )

    val a4 = arrayOf(
        intArrayOf(1, 1, 2, 2)
    )
    println(b.solution(6, 6, a1))
    println(b.solution(3, 3, a2))
    println(b.solution(100, 97, a3))
//    println(b.solution(2, 2, a4))
}

