package pg.lv0

fun main() {
    MakeArray2().solution(5, 555).forEach { println(it) }
    //MakeArray2().solution(10, 20).forEach { println(it) }

}

class MakeArray2 {

    fun solution(l: Int, r: Int): IntArray {

        /**
         * return (l..r).filter { it.toString().all { ch -> ch == '0' || ch == '5' } }.takeIf(List<Int>::isNotEmpty) ?: listOf(-1)
         */

        val result = (l..r).filter {
            val str = it.toString()

            (!(str.contains("1") || str.contains("2") || str.contains("3")
                    || str.contains("4") || str.contains("6") || str.contains(
                "7"
            ) || str.contains("8") || str.contains("9")))
        }.toIntArray()

        return if (result.isEmpty()) intArrayOf(-1) else result
    }
}