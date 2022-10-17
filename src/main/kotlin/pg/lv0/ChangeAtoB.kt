package pg.lv0

fun main() {
    ChangeAtoB().solution("olleh", "hello")
    ChangeAtoB().solution("allpe", "apple")
}

class ChangeAtoB {

    fun solution(before: String, after: String): Int {

        val beforeArray = before.toCharArray().also { it.sort() }
        val afterArray = after.toCharArray().also { it.sort() }

        return if (beforeArray.contentEquals(afterArray)) 1 else 0
    }
}