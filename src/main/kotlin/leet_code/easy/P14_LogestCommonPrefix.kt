package leet_code.easy

class P14_LogestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {

        strs.sortBy { it.length }

        var answer = -1

        for (i in strs[0].indices) {
            val base = strs[0][i]
            var isPossible = true

            for (j in 1 until strs.size) {
                val next = strs[j][i]

                if (base != next) {
                    isPossible = false
                    break
                }
            }

            if (isPossible) {
                answer = i
            } else {
                break
            }
        }

        return if (answer == -1) "" else strs[0].substring(0..answer)
    }

}

fun main() {
    //range 2의 -31 ~ 2의 31
    //P14_LogestCommonPrefix().longestCommonPrefix(arrayOf("dog", "racecar", "car")).also { println(it) }
    //P14_LogestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")).also { println(it) }
    P14_LogestCommonPrefix().longestCommonPrefix(arrayOf("cir", "car")).also { println(it) }
}