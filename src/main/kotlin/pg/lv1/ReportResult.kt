package pg.lv1

class ReportResult {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size) { 0 }

        // 신고받은 기록
        val result: MutableMap<String, Int> = mutableMapOf()
        val reportMap: MutableMap<String, MutableList<String>> = mutableMapOf()

        id_list.forEach { result[it] = 0 }

        for (str in report) {
            val token = str.split(" ")
            val reporter = token[0] // 신고한사람
            val target = token[1] // 신고당한이

            if (reportMap.containsKey(target)) {
                if (reportMap[target]?.contains(reporter) == false) {
                    reportMap[target]?.add(reporter)
                }
            } else {
                reportMap[target] = mutableListOf(reporter)
            }
        }

        // a가 신고한 사람 b, c, d 일 때 b,c,d가 k이상 받았는가
        for (i in id_list.indices) {
            // a가 신고한 거는 list에 있고
            for (key in reportMap.keys) {

                if (reportMap[key]?.contains(id_list[i]) == true) {
                    if ((reportMap[key]?.size ?: 0) >= k)
                        answer[i] += 1
                }
            }
        }
        return answer
    }
}