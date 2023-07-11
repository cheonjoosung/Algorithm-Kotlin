package leet_code.easy

class P09_PaindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        return if (x < 0) false
        else if (x == 0) true
        else {
            val xStr = x.toString()
            var isPossible = true
            for (i in 0 until xStr.length/2) {
                if (xStr[i] != xStr[xStr.length - i - 1]) {
                    isPossible = false
                    break
                }
            }

            isPossible
        }
    }
}

fun main() {
    //range 2의 -31 ~ 2의 31
}