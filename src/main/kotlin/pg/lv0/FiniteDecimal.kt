package pg.lv0

class FiniteDecimal {

    fun solution(a: Int, b: Int): Int {
        val gcd = gcd(a,b)

        val list = mutableListOf<Int>()
        var num = b / gcd
        var i = 2

        while (i <= num ) {
            if (num % i == 0) {
                if (!list.contains(i)) list.add(i)
                num /= i
            } else {
                i++
            }
        }

        val count = list.count { it != 2 && it != 5 }
        return if (count >= 1) 2 else 1
    }

    private fun gcd(a: Int, b: Int): Int {
        val maximum = a.coerceAtLeast(b)
        val minimum = a.coerceAtMost(b)

        return if (minimum == 0) {
            a.coerceAtLeast(b)
        } else {
            gcd(minimum, maximum % minimum)
        }
    }
}