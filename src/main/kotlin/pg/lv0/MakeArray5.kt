package pg.lv0

fun main() {
    MakeArray5().solution(arrayOf("0123456789","9876543210","9999999999999"), 50000, 5, 5).forEach {
        println(it)
    }

}

class MakeArray5 {

    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        val set = mutableListOf<Int>()

        intStrs.forEach {
            val intString = it.substring(s, s+l)
            val intValue = intString.toInt()
            //println("$intString $intValue")
            if (intValue > k) set.add(intValue)
        }

        return set.toIntArray()
    }
}