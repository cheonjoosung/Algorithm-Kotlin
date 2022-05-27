package pg.lv1

class KeyPad {
    private fun solution(numbers: IntArray, hand: String): String {
        val x = intArrayOf(3, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3) //0~9 그리고 * #
        val y = intArrayOf(1, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 2) //0~9 그리고 * #
        var answer = StringBuilder()
        /*
        1,4,7 왼손만, 3,6,9 오른손만, 2,5,8,0 가까운손 거리가 같다면 오른/왼 손잡이에 따라 나눠짐
        1 2 3 (0,0) (0,1) (0,2)
        4 5 6 (1,0) (1,1) (1,2)
        7 8 9 (2,0) (2,1) (2,2)
        * 0 # (3,0) (3,1) (3,2)
         */

        val pairList = x.zip(y).toList()

        var left = 10
        var right = 11

        for (i in numbers) {
            var choice = "L"

            when (i) {
                1, 4, 7 -> choice = "L"
                3, 6, 9 -> choice = "R"
                2, 5, 8, 0 -> {
                    val leftTemp = mapping(i, left, pairList)
                    val rightTemp = mapping(i, right, pairList)

                    if (leftTemp == rightTemp) choice = if (hand == "right") "R" else "L"
                    else if (leftTemp > rightTemp) choice = "R"
                    else choice = "L"
                }
            }

            if (choice == "R") right = i else left = i

            answer.append(choice)
//        println("$choice == right:$right  /  left:$left")
        }

        return answer.toString()
    }

    fun mapping(a: Int, b: Int, pairList: List<Pair<Int, Int>>): Int {
//    println("mapping $a $b")
        val pairA = pairList[a]
        val pairB = pairList[b]

        return Math.abs(pairA.first - pairB.first) + Math.abs(pairA.second - pairB.second)
    }
}