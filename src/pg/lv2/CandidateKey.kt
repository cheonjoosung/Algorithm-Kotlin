package pg.lv2

import java.util.ArrayList
import java.util.HashMap

//https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-Java
class CandidateKey {
//    [["100","ryan","music","2"]
//    ["200","apeach","math","2"],
//    ["300","tube","computer","3"],
//    ["400","con","computer","4"],
//    ["500","muzi","music","3"],
//    ["600","apeach","music","2"]]

    //유일성을 만족하는 최소의 후보키가 몇개인가? 위에서는 2개 [이름, 전공]
    fun solution(relation: Array<Array<String>>): Int {
        val candidateKey = ArrayList<Int>()

        val row = relation.size
        val col = relation[0].size

        /*
            1. 모든 속성의 조합 구한다
            2. 만들어진 조합이 이전에 만들어진 후보키 포함 여부
                2-1. 포함하면 다음조합으로
                2-2. 포함하지 않으면 유일성 체크하여 후보키 여부 판단
            3. 후보키 갯수 반환
         */
        for (set in 1 until (1 shl col)) { //모든 조합구하기
            println("set : ${set.toString(2)}")

            // 2-1 최소성 검사 : (1) 을 이전에 포함했다면 그다음 조합에서 (1,2)가 되더라도 최소성 만족 못함
            if (!isMinimal(set, candidateKey)) continue

            // 2-2 유일성 검사
            if (isUnique(set, row, col, relation)) {
                println("Unique : ${set.toString(2)}")
                candidateKey.add(set)
            }
        }

        return candidateKey.size
    }

    private fun isUnique(
        set: Int,
        row: Int,
        col: Int,
        relation: Array<Array<String>>
    ): Boolean {
        val map = HashMap<String, String>()

        // 자릿수 구하기
        for (i in 0 until row) {
            var dataByKeySet = ""

            for (th in 0 until col) {
                // 1 << th th번째 자릿수 1 << 3 = 1000(2)
                // set & (1 << 소) 해당 set과 같은 자리 찾아서 키 만드는 작업
                    println("$set ${1 shl th} ${set and (1 shl th) != 0}")
                if (set and (1 shl th) != 0) {
                    // set 10 2번째 인덱스와 같은 것만 키로 만드는 작업
                    dataByKeySet += relation[i][th]
                }
            }

            println("dataByKetSet : $dataByKeySet")

            if (map.containsKey(dataByKeySet))
                return false
            else
                map[dataByKeySet] = dataByKeySet
        }

        return true
    }

    private fun isMinimal(set: Int, candidateKey: ArrayList<Int>): Boolean {
        for (key in candidateKey) {
            // and 교집합으로 key가 나옴
            if (key and set == key) return false
        }

        return true
    }
}
