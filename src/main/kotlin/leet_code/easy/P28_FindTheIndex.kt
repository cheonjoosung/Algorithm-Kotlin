package leet_code.easy

class P28_FindTheIndex {
    fun strStr(haystack: String, needle: String): Int {
        val haystackLength = haystack.length
        val needleLength = needle.length

        for (i in 0..haystackLength - needleLength) {
            var found = true
            for (j in 0 until needleLength) {
                if (haystack[i + j] != needle[j]) {
                    found = false
                    break
                }
            }
            if (found) {
                return i
            }
        }

        return -1
    }
}

fun main() {
    P28_FindTheIndex().strStr("sadbutsad", "sad").also { print(it) }
    P28_FindTheIndex().strStr("leetcode", "leeto").also { print(it) }
}