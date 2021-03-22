package backjun.s1

import java.io.BufferedReader
import java.io.InputStreamReader

class TreeExit {

    fun main() {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val n  = br.readLine().toInt()

        /*
            1. 성원 -> 형석 순,,
            2. 모든 리프노드에 말이 존재(자식이 없는 노드), 1은 루트
            3. 더이상 고를말이 없는 경우 그 사람이 짐
            8 NO
            8 1
            1 4
            7 4
            6 4
            6 5
            1 3
            2 3

        */

        for (i in 1 until n) {

            val line = br.readLine().split(" ")

            val a = line[0].toInt()
            val b = line[1].toInt()


        }

    }
}

