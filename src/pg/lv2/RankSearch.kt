package pg.lv2

class RankSearch {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)

        var idx = 0

        for (que in query) {
            println(que)
            val token = que.replace("and ", "").split(" ")
            var cnt = 0

            for (inf in info) {
                var isPossible = true

                for (value in token) {
                    if (value == "-") continue

                    if (value.toIntOrNull() ?: -1 != -1) {
                        val temp = inf.split(" ").last()

                        if (temp.toIntOrNull() ?: -1 != -1) {
                            if (value.toInt() > temp.toInt()) {
                                isPossible = false
                                break
                            }
                        }
                    } else {
                        if (!inf.contains(value)) {
//                            println("B $inf $value")
                            isPossible = false
                            break;
                        }
                    }
                }
                if (isPossible) cnt += 1
//                println("[$idx] $inf $isPossible $cnt")
            }

            answer[idx++] = cnt
        }

//        for (temp in answer)
//            println(temp)

        return answer
    }
}