import pg.lv2.MenuRenewal

fun main() {

    val s = MenuRenewal()

    val o1 = arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH")
    val c1 = intArrayOf(2, 3, 4)

    val o2 = arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD")
    val c2 = intArrayOf(2, 3, 5)

    val o3 = arrayOf("XYZ", "XWY", "WXA")
    val c3 = intArrayOf(2, 3, 4)

    println(s.solution(o1, c1))
    println(s.solution(o2, c2))
    println(s.solution(o3, c3))
}

