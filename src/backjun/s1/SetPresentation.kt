package backjun.s1

import java.util.*


class SetPresentation {

    fun main() {

        val sc = Scanner(System.`in`)

        val n = sc.nextInt()
        val tc = sc.nextInt()

        // 루트 노드 찾기 위해서
        val arr = IntArray (n + 1) { i -> i }

        for (i in 1..tc) {
            val isUnion = (sc.nextInt() == 0)

            val a = sc.nextInt()
            val b = sc.nextInt()

            if (isUnion) {
                union(a , b, arr)
            } else {
                if (isSameSet(a, b, arr))
                    println("YES");
                else
                    println("NO");
            }
        }
    }

    /**
     * 재귀로 자신의 부모 값 찾기
     */
    private fun findRoot(a: Int, arr: IntArray): Int {
        return if (a == arr[a]) a
        else {
            arr[a] = findRoot(arr[a], arr)
            arr[a]
        }
    }
    /**
     * {1} + {4} -> arr[1] = 1 & arr[4] = 4 1<4 => arr[4] = 1
     * {1, 4} + {7} => {4} + {7} -> arr[4]의 값 1 union arr[7] 값 7 하면 arr[7] = 1
     * {1, 4, 7}    =>
     */
    private fun union(a: Int, b: Int, arr: IntArray) {
        val x = findRoot(a, arr)
        val y = findRoot(b, arr)

        if (x != y) {
            if (x<y) arr[y] = x
            else arr[x] = y
        }
    }

    private fun isSameSet(a: Int, b: Int, arr: IntArray) : Boolean {
        val x = findRoot(a, arr)
        val y = findRoot(b, arr)

        return (x == y)
    }

}