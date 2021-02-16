package pg.lv1

import java.lang.StringBuilder

class SecretMap {
    fun solution(n: Int, arr1: Array<Int>, arr2: Array<Int>): Array<String> {
        /*  5
            arr1	[9, 20, 28, 18, 11]
            arr2	[30, 1, 21, 17, 28]
            출력	["#####","# # #", "### #", "# ##", "#####"]

            6
            arr1	[46, 33, 33 ,22, 31, 50]
            arr2	[27 ,56, 19, 14, 14, 10]
            출력	["######", "### #", "## ##", " #### ", " #####", "### # "]
         */
        val ans = Array(n) { "" }

        for (i in 0 until n) {
            var based = getBaseBinary(n)  //"000000"

            //1. 2진수로 바꾸기
            var n1 = arr1[i].toString(2)
            var n2 = arr2[i].toString(2)

            //2. n 크기의 based 문자열에 뒤에서부터 (n1,n2) 문자열 바꾸기
            n1 = based.replaceRange(n-n1.length until n, n1)
            n2 = based.replaceRange(n-n2.length until n, n2)

            //3. (n1).zip(n2) -> (n1,n2) (n1,n2) 가 반복됨 같으면 0 아니면 1 리턴
            val temp = (n1).zip(n2).map { if(it.first == it.second && it.first == '0') "0" else "1" }.toTypedArray()
            val sb = StringBuilder()
            temp.map { if (it == "1") "#" else " " }.forEach { sb.append(it) }
            ans[i] = sb.toString()
        }

        for (str in ans) {
            println(str)
        }

        return ans
    }

    private fun getBaseBinary(n: Int): String {
        var sb = StringBuilder()
        for (i in 1..n) {
            sb.append("0")
        }
        return sb.toString()
    }
}