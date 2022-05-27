package pg.lv3

class StarSequence {

    var answer = 0
    var isFind = false

    fun solution(a: IntArray): Int {

        val size = a.size

        for (i in 2 until size step 2) {
            val visited = BooleanArray(size) { false }
            var list = mutableListOf<Int>()

            isFind = false
            dfs(0, 0, size, i, visited, a, list)
        }

        return answer
    }

    private fun dfs(idx: Int, cnt: Int, arraySize: Int, targetSize: Int, visited: BooleanArray, arr: IntArray, list: MutableList<Int>) {

        if (!isFind) {
            if (cnt == targetSize) {
                //스타수열?
                if (isStarSequence(list)) {
                    answer = Math.max(answer, list.size)
                    isFind = true
                }
                return
            }

            for (i in idx until arraySize) {

                if (visited[i]) continue

                visited[i] = true
                list.add(arr[i])
                dfs(i, cnt + 1, arraySize, targetSize, visited, arr, list)
                list.removeAt(list.size - 1)
                visited[i] = false
                if (isFind) break
            }

        }
    }

    private fun isStarSequence(list: MutableList<Int>): Boolean{

        val size = list.size
        for (i in 0 until size step 2) {
            if (list[i] == list[i+1]) return false
        }

        val first = list[0] //2 ~ size 1개
        val second = list[1] // 2  ~ size 1개

        var isFirstPossible = true
        var isSecondPossible = true

        for (i in 2 until size step 2) {
            // a b 값
            if (isFirstPossible && first != list[i] && first != list[i+1]) isFirstPossible = false

            if (isSecondPossible && second != list[i] && second != list[i+1]) isSecondPossible = false
        }

        //first second 중 하나만 존재해야함
        if (isFirstPossible && isSecondPossible) return false
        if (!isFirstPossible && !isSecondPossible) return false

        return true
    }
}