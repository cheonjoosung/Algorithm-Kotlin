package etc

import java.util.*

class Exchange {

    fun main() {
//        var input = intArrayOf(4, 5, 3, 2, 1)
//        var output = intArrayOf(2, 4, 4, 5, 1)

        var input = intArrayOf(5, 4, 5, 4, 5)
        var output = intArrayOf(1, 2, 3, 5, 4)

        var answer = 0

        val size = input.size
        val q: Queue<P> = LinkedList()

        val matched = BooleanArray(size) { false }

        for (i in 0 until size) {
            if (input[i] == output[i]) {
                matched[i] = true
            } else {
                q.add(P(i, input[i], output[i]))
            }
        }

        /*
            종료조건 큐 empty
            1. input 을 큐에 넣기
            2. 큐에 꺼내고 matched 중에 찾아서 교체
            2-1. 교체x && wantX 가 없으면 큐에 제거
            2-2. 그 반대의 경우 큐에 넣기 (idx <-> nxIdx) 교체중 둘중 하나가 된 경우
         */
        //1. input을 큐에 넣기
        //2
        //2. 이 중에 output 에서 matched == false 찾아서 바꾸기

        while (!q.isEmpty()) {

            val p = q.poll()

            if (matched[p.idx]) continue
            else {

                val idx = p.idx
                val have = p.have
                val want = p.want

                var isChanged = false //바뀌지 않고 원하는 값도 없는 경우 큐에서 제거해야함

                for (i in 1 until size) {

                    if (matched[i]) continue

                    val nxIdx = i
                    val nxHave = input[i]
                    val nxWant = output[i]

                    if (have == nxWant || want == nxHave) { //i가 원하는 것과 j가 가진것과 같을 때
                        val temp = input[idx]
                        input[idx] = input[nxIdx]
                        input[nxIdx] = temp

                        isChanged = true
                    }

                    if (input[idx] == output[idx]) matched[idx] = true
                    else {
                        if(isChanged) q.add(p)
                    }
                    if (input[nxIdx] == output[nxIdx]) matched[nxIdx] = true
                }
            }

        }

        for (i in 0 until size) {
            if (input[i] == output[i])
                answer++
        }

        println(size - answer)
    }
}

data class P(val idx: Int, val have: Int, val want: Int)