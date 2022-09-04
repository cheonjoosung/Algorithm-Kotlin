fun main() {

}

val ans = IntArray(2) { 0 }
fun solution(arr: Array<IntArray>): IntArray {

    val totalSize = arr.size
    divide(0, 0, totalSize, arr)
    return ans
}

private fun divide(x: Int, y: Int, size: Int, arr: Array<IntArray>) {

    if (isCheck(x, y, size, arr)) {
        ans[arr[x][y]] += 1
        return
    }

    divide(x, y, size / 2, arr)
    divide(x + size / 2, y, size / 2, arr)
    divide(x, y + size / 2, size / 2, arr)
    divide(x + size / 2, y + size / 2, size / 2, arr)
}

private fun isCheck(x: Int, y: Int, size: Int, arr: Array<IntArray>): Boolean {
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (arr[x][y] != arr[i][j]) return false
        }
    }

    return true
}