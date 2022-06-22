package backjun.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


var sb = StringBuilder()
lateinit var tree: ArrayList<Int>

fun main() {

    /*
    50 30 24 5 28 45 98 52 60
    루트인 50보다 큰 것은 우측, 작은것은 좌측 노드
    5 28 24 45 30 60 52 98 50
     */
    val br = BufferedReader(InputStreamReader(System.`in`))

    tree = ArrayList<Int>()
    while (true) {
        val n = br.readLine()
        if (n == null || n == "") break
        // 더이상의 인풋이 존재하지 않으면 break
        tree.add(n.toInt())
    }

    postOrder(0, tree.size - 1)
}

fun postOrder(idx: Int, end: Int) {
    if (idx > end) return
    // 리스트 범위를 벗어나면 return
    var mid = idx + 1
    while (mid <= end && tree[mid] < tree[idx]) {
        mid++
    }

    postOrder(idx + 1, mid - 1)
    postOrder(mid, end)
    println(tree[idx])
}
