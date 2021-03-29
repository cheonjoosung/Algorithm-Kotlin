package pg.lv2

class MenuRenewal {
    /*
    ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]     =>	["AC", "ACDE", "BCFG", "CDE"]
    ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"] [2,3,5]   =>	["ACD", "AD", "ADE", "CD", "XYZ"]
    ["XYZ", "XWY", "WXA"]	[2,3,4]	                            =>  ["WX", "XY"]
     */
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = emptyArray()


        /*
        ABC  FG
        A C
          CDE
        A CDE
        B C  FG
        A CDE  H

        결과값의 (코스요리문자열, 코스수)를 문자열 오름름차순 정렬
        1. orders 길이로 오름차순 정
        2. 주어진 코스 길이내에서 가능한 모든 문자열의 조합을 찾아서 리스트에 추가
        3. 정렬 끝
         */

        orders.sortBy { it.length }

        for (i in orders.indices) {

            val str = orders[i]

            for (i in course.indices) {
                val visited = BooleanArray(i) { false }
                find(str, course[i], 0, visited)
            }
        }

        return answer
    }

    fun find(str: String, n: Int, cnt: Int, visited: BooleanArray) {
        if (n == cnt) {
            //add menu
            return
        }

        for (i in 0..str.length) {
            if (visited[i]) continue

            visited[i] = true
            find(str, n, cnt + 1, visited)
            visited[i] = false
        }

    }
}

data class Menu(var menu: String, var cnt: Int)