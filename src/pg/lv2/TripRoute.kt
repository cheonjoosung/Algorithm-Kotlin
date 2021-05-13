package pg.lv2

class TripRoute {
    var visit = booleanArrayOf()
    val list = mutableListOf<String>()
    val answer = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {

        for (i in tickets.indices) {

            if (tickets[i][0] == "ICN") {

                visit = BooleanArray(tickets.size) {false}
                visit[i] = true

                list.add("ICN")
                list.add(tickets[i][1])

                dfs(tickets, 1)

                visit[i] = false
                list.removeAt(list.lastIndex)
                list.removeAt(list.lastIndex)
            }
        }

        return answer.sorted()[0].split("-").toTypedArray()
    }

    fun dfs(tickets: Array<Array<String>>, depth: Int){
        if (depth == tickets.size) {
            answer.add(list.joinToString("-"))
        } else {

            val next = list.last()

            for (i in tickets.indices) {

                if (visit[i]) continue

                if (tickets[i][0] == next) {
                    visit[i] = true

                    list.add(tickets[i][1])
                    dfs(tickets, depth + 1)
                    list.removeAt(list.lastIndex)

                    visit[i] = false
                }
            }
        }
    }
}