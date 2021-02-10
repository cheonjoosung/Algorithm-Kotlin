package backjun.p1000_1999

import java.util.*

class PrintQueue {

    private fun solution() {
        /*3
          1 0 5 => 1
          4 2 1 2 3 4 => 2
          6 0 1 1 9 1 1 1 => 5 */
        val sc = Scanner(System.`in`)
        val tc = sc.nextInt()

        for (i in 1..tc) {
            var answer = 0

            val n = sc.nextInt()
            val idx = sc.nextInt() //시작이 0부터

            var arr = mutableListOf<Dot>()

            for (j in 0 until n)
                arr.add(Dot(j, sc.nextInt()))

            var popIdx = -1
            while (popIdx != idx) {
                val max = arr.maxByOrNull { it.value }?.value //arr의 value로 Max를 찾고 그게없으면 null 반환

                //max 가 null이 아닐경우 아래 코드 실행
                max?.let {
                    val dotTemp = arr[0]
                    arr.removeAt(0)

                    if (dotTemp.value >= max) {
                        popIdx = dotTemp.idx
                        answer++
                    } else {
                        arr.add(dotTemp)
                    }
                }
            }

            println(answer)
        }
    }
}

data class Dot(val idx: Int, val value: Int)