package pg.lv2

class Solution2 {

    private val hashMap = HashMap<String, MutableList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {

        val answer: IntArray = IntArray(query.size)

        info.forEach { dfs("", 0, it.split(" ").toTypedArray()) } // info의 값을 dfs를 이용하여 초기화

        hashMap.values.forEach { it.sort() } // hm의 score를 이진 탐색하기 위해 정렬

        for (i in query.indices) {
            val str = query[i].replace(" and ", "").split(" ") // query의 값을 HashMap의 key, score로 변환

            answer[i] = search(str[0], str[1].toInt())// 조건에 해당하는 값을 answer에 저장
        }
        return answer
    }

    fun dfs(key: String, depth: Int, row: Array<String>) {

        // 깊이가 4인 경우 마지막 점수 항목에 도달한 것임
        if (depth == 4) {

            if (hashMap.containsKey(key)) hashMap[key]!!.add(row[depth].toInt()) // 해당 키가 있을 경우 배열에 현재 값의 점수 추가
            else hashMap[key] = mutableListOf(row[depth].toInt()) // 해당 키가 없을 경우 MutableList 초기화

            return
        }

        dfs("$key-", depth + 1, row) // 다음 필드가 없는 경우로 초기화
        dfs("$key${row[depth]}", depth + 1, row) // 다음 필드가 있는 경우로 초기화
    }

    private fun search(key: String, score: Int): Int {

        if (!hashMap.containsKey(key)) return 0 // 만일 key가 없으면 해당되는 사람도 없는 것임으로 0리턴

        var start = 0 // 이진 탐색을 위한 start 변수
        var end = hashMap[key]!!.size - 1 // 이진 탐색을 위한 end 변수

        while (start <= end) { // start가 end보다 작을 경우 반복

            val mid = (start + end) / 2

            if (hashMap[key]!![mid] < score) start = mid + 1 // query의 점수가 hm[key][mid] 점수보다 클 경우 시작 값을 mid + 1로 변경
            else end = mid - 1 // query의 점수가 hm[key][mid] 점수보다 작을 경우 끝 갚을 mid + 1로 변경
        }

        return hashMap[key]!!.size - start // 현재 key의 길이에서 위에서 계산한 start 값을 빼면 검색한 score 값과 같거나 큰 값의 개수가 되는데 해당 값을 리턴
    }
}