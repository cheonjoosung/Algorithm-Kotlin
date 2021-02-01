package pg.lv1

class Third {
    fun solution2(n: Int): Int {
        return n.toString(3).reversed().toInt(3)
    }

    private fun solution(n: Int): Int {
        var answer = n

        var temp = ""
        while (answer >= 3) {
            var value = answer % 3
            temp = temp.plus(value)
            answer /= 3
        }
        temp = temp.plus(answer)

        var n = temp.length-1
        var res = 0

        for (i in temp.indices) {
            res += temp[i].toString().toInt() * (Math.pow(3.0, (n-i).toDouble())).toInt()
        }

        return res
    }
}