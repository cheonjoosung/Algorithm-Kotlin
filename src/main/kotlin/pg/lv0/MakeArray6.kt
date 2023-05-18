package pg.lv0

fun main() {
    MakeArray6().solution(intArrayOf(0,1,1,1,0)).forEach { println(it) }
    MakeArray6().solution(intArrayOf(0,1,0,1,0)).forEach { println(it) }
    MakeArray6().solution(intArrayOf(0,1,1,0)).forEach { println(it) }

}

class MakeArray6 {

    fun solution(arr: IntArray): IntArray {

        var i = 0
        val stk = mutableListOf<Int>()

        while (i< arr.size) {
            if (stk.isEmpty()) {
                stk.add(arr[i++])
            } else {
                if (stk.last() == arr[i]) {
                    stk.removeLast()
                    i++
                } else {
                    stk.add(arr[i++])
                }
            }
        }
        return if (stk.isEmpty()) intArrayOf(-1) else  stk.toIntArray()
    }
}