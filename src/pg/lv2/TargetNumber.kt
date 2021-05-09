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

    private fun dfs(arr: IntArray, n: Int, sum: Int, target: Int): Int {
        return if (n == arr.size)
            if (sum == target) 1 else 0
        else {
            dfs(arr, n + 1, sum - arr[n], target)
            + dfs(arr, n + 1, sum + arr[n], target)
        }
    }
}