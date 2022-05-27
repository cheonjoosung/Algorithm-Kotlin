package pg.lv2

class RankSearch {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)

        var idx = 0

        //info java backend junior pizza 150
        //query java and backend and junior and pizza 100
        for (que in query) {
            val queToken = que.replace("and ", "").split(" ")

            var cnt = 0

            for (inf in info) {
                val infToken = inf.split(" ")

                if (queToken[4].toInt() > infToken[4].toInt()) {
                    continue
                }

                if (queToken[0] != "-" && queToken[0] != infToken[0]) {
                    continue
                }

                if (queToken[1] != "-" && queToken[1] != infToken[1]) {
                    continue
                }

                if (queToken[2] != "-" && queToken[2] != infToken[2]) {
                    continue
                }

                if (queToken[3] != "-" && queToken[3] != infToken[3]) {
                    continue
                }

                cnt++
            }
            answer[idx++] = cnt
        }

        for (temp in answer)
            println(temp)

        return answer
    }
}