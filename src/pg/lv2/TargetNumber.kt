package pg.lv2

class TargetNumber {

    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { list, i ->
            println("$list")
            list.run {
                map { it + i } + map { it - i }
            }
        }.count { it == target }
    }
}