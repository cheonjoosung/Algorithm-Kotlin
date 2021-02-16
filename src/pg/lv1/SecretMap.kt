package pg.lv1

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

        (arr1.zip(arr2))
            .map { it.first.toString(2).plus(" ").plus(it.second.toString(2)) }
            .forEach { println(it) }

        for (i in 0 until n) {
            var n1 = arr1[i].toString(2)
            var n2 = arr2[i].toString(2)

            val based = "000000"

            if (n1.length == n) {

            }
        }


        return ans
    }
}