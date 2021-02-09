package pg.lv1

import java.util.StringTokenizer




class DotProduct {
    private fun solution(a: IntArray, b: IntArray) : Int {
        var answer = 0

        for (i in a.indices) {
            answer += a[i] * b[i]
        }

        return answer
    }

    private fun solution2(a: IntArray, b: IntArray) : Int {
        return a.zip(b).map { it.first * it.second } .sum()
    }

    /*
    1. 2문제 - 1문제 공통 + 1문제 개인
    2. 삼성전자 - BFS/DFS + 구현 -> 거의 정형화
    3. 카카오 -
    4.

    - 1문제 올리고 공통으로 같이 선정 1~6번 순서대로 고르는거야 (강제성)
    - 개인문제 알아서 풀고 개인존 만들고 올리기 (필요시 공유)
    - 공통문제 리뷰 -> 개인문제 희망자에 의해 리뷰 -> 다음주 문제 선정

     */
}