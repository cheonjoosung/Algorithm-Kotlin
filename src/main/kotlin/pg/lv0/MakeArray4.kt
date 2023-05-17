package pg.lv0

fun main() {
    MakeArray4().solution(intArrayOf(1,4,2,5,3)).forEach {
        println(it)
    }

}

class MakeArray4 {

    fun solution(arr: IntArray): IntArray {
        val list = mutableListOf<Int>()

        var i = 0

        while (i < arr.size) {
            if (list.isEmpty()) {
                list.add(arr[i++])
            } else {
                if (list.last() < arr[i]) {
                    list.add(arr[i++])
                }
                else list.removeLast()
            }
        }


        return list.toIntArray()
    }
}