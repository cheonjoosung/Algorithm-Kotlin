package backjun.g3

import java.util.*

class Sum {

    fun main() {
        var answer = 0L

        val sc = Scanner(System.`in`)
        val n = sc.nextInt()

        var arr = LongArray(10)
        var isFirstZeo = BooleanArray(10) { false }

        for (i in 1..n) { //n은 50보다 작거나 같은 자연수
            val b = sc.next()

            calc(arr, b)
            isFirstZeo[check(b[0])] = true
        }

        // (index, LongValue) 로 맵핑 후 LongValue가 0이 아닌 값들 중 내림차순으로 정렬
        var list: MutableList<Value> = mutableListOf()
        arr.mapIndexed { index, l ->  list.add(Value(index, l))}
        list = list.filter { it.value != 0L }.sortedByDescending { it.value }.toMutableList()

        //마지막에 위취한 값의 알파벳이 0이 되면 안되므로 0키 되도 되는값을 찾은 후 한칸씩 밀어주기
        if (list.size == 10 && isFirstZeo[list[9].idx]) {
            for (i in 8 downTo 0) {
                if (!isFirstZeo[list[i].idx]) {
                    val item = list[i]
                    list.removeAt(i)
                    list.add(item)
                    break
                }
            }
        }

        var num = 9L
        for (item in list) {
           answer += num-- * item.value
        }

        println(answer)
    }

    private fun calc(arr: LongArray, str: String) {
        val size = str.length

        for (i in 0 until size) {
            val mul = Math.pow(10.0, (size - i - 1).toDouble()).toLong()
            val idx = check(str[i])

            arr[idx] = arr[idx] + mul
        }
    }


    private fun check(ch: Char): Int {
        var res = -1

        when (ch) {
            'A' -> res = 0
            'B' -> res = 1
            'C' -> res = 2
            'D' -> res = 3
            'E' -> res = 4
            'F' -> res = 5
            'G' -> res = 6
            'H' -> res = 7
            'I' -> res = 8
            'J' -> res = 9
        }

        return res
    }
}

data class Value(val idx: Int, val value: Long)