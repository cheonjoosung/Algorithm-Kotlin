package pg.lv2

import kotlin.math.max

class MenuRenewal {
    /*
    ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]     =>	["AC", "ACDE", "BCFG", "CDE"]
    ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"] [2,3,5]   =>	["ACD", "AD", "ADE", "CD", "XYZ"]
    ["XYZ", "XWY", "WXA"]	[2,3,4]	                            =>  ["WX", "XY"]
     */
    var maxStr = ""
    var maxCnt = 0
    var tempList = mutableListOf<String>()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()

        orders.sortBy { it.length }

        for (i in course.indices) { //2, 3, 4

            for (j in orders.indices) {

                val str = orders[j]
                val visited = BooleanArray(str.length) { false }

                find(str, course[i], 0, visited, 0, orders)
            }

            if (maxCnt != 0) { //갱신여부체크
                maxStr = ""
                maxCnt = 0
            }

            answer.addAll(tempList)
            tempList = mutableListOf()
        }

        answer.sort()

        return answer.toTypedArray()
    }

    private fun find(str: String, n: Int, cnt: Int, visited: BooleanArray, idx: Int, orders: Array<String>) {
        if (n == cnt) {
            val menu = StringBuilder()

            for (i in visited.indices) {
                if (visited[i]) {
                    menu.append(str[i]) //메뉴 찾기 ABC -> 메뉴수2개이면 (AC, AB, BC)
                }
            }

            var matchCnt = 0
            for (order in orders) {
                var res = true

                for (i in menu.indices) {
                    val c = menu[i]

                    if (!order.contains(c)) {
                        res = false
                        break
                    }
                }

                if (res) {
                    matchCnt++
                }

            }

            if (matchCnt >= 2) {
                if (matchCnt > maxCnt) {
                    maxCnt = matchCnt
                    maxStr = menu.toString()

                    tempList = mutableListOf()
                    tempList.add(menu.toList().sorted().joinToString(""))
                } else if (matchCnt == maxCnt) {
                    if (!tempList.contains(menu.toList().sorted().joinToString("")))
                        tempList.add(menu.toList().sorted().joinToString(""))
                }

            }

            return
        }

        for (i in idx until str.length) {
            if (visited[i]) continue

            visited[i] = true
            find(str, n, cnt + 1, visited, i + 1, orders)
            visited[i] = false
        }

    }
}