package pg.lv2

class RankSearch {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size)

        /*
        var info = arrayOf("java backend junior pizza 150","python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260","java backend junior chicken 80",
        "python backend senior chicken 50")
    var query = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100",
        "- and - and - and - 150")
         */

        var cnt = 0
        for (temp in query) {
            println("String is $temp")

            val token = temp.split("and")


            for (info in info) {
                val isPossible = false

                for (value in token) {

                }

                if (isPossible) cnt = cnt+1
            }
        }




        return answer
    }
}