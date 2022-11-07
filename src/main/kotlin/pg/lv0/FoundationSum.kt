package pg.lv0

class FoundationSum {

    fun solution(denum1: Int, num1: Int, denum2: Int, num2: Int): IntArray {
        var answer: IntArray = IntArray(2) { 0 }

        var top = denum1 * num2 + denum2 * num1
        var bottom = num1 * num2

        val common = gcd(top, bottom)
        answer[0] = top / common
        answer[1] = bottom / common

        return answer
    }

    fun gcd(a: Int, b: Int):Int {
        return if (a % b == 0) b
        else gcd(b, a % b)
    }
}