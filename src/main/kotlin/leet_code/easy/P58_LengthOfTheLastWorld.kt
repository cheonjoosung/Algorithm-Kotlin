package leet_code.easy

class P58_LengthOfTheLastWorld {
    fun lengthOfLastWord(s: String): Int {
        val token = s.trim().split(" ")
        return token.last().length
    }
}

fun main() {
    P58_LengthOfTheLastWorld().lengthOfLastWord("Hello World").also { println(it) }
    P58_LengthOfTheLastWorld().lengthOfLastWord("   fly me   to   the moon  ").also { println(it) }
    P58_LengthOfTheLastWorld().lengthOfLastWord("luffy is still joyboy").also { println(it) }
}