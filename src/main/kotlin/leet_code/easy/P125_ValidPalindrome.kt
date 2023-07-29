package leet_code.easy

class P125_ValidPalindrome {

    // 1 <= s.length <= 2*100000
    fun isPalindrome(s: String): Boolean {
        val noBlankString = s.replace("[^a-zA-Z0-9]".toRegex(),"").toLowerCase()

        return if (noBlankString.isEmpty()) true
        else {
            val size = noBlankString.length
            for (i in 0 until size/2) {
                if (noBlankString[i] != noBlankString[size-i-1]) {
                    return false
                }
            }

            return true
        }
    }
}

fun main() {
    P125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama").also { println(it) }
    P125_ValidPalindrome().isPalindrome("race a car").also { println(it) }
    P125_ValidPalindrome().isPalindrome(" ").also { println(it) }
}