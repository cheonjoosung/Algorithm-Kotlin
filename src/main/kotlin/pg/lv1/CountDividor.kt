package pg.lv1

class CountDividor {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        val range = left..right

        for (i in range) {
            answer += count(i)
        }

        return answer
    }

    private fun count(num: Int) : Int {

        val range = 1..Math.sqrt(num.toDouble()).toInt()
        val set = hashSetOf<Int>()

        for (i in range) {
            if (num % i == 0) {
                set.add(i)
                set.add(num/i)
            }
        }

        return if (set.size % 2 == 0) num else num*-1
    }
}