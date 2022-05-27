import java.util.Scanner

var N: Int = 0
var S: Int = 0
var count: Int = 0
var arr: IntArray = intArrayOf()

fun main() = with(Scanner(System.`in`)){
    N = nextInt()
    S = nextInt()
    arr = IntArray(N) { nextInt() }

    dfs(0, 0)

    if (S==0) println(count - 1)
    else println(count)
}

fun dfs(v: Int, su: Int) {
    if (v == N) {
        if (su == S) count++
        return
    }

    dfs(v + 1, su + arr[v])
    dfs(v + 1, su)
}