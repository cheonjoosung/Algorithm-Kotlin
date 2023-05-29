package pg.lv1

fun main() {
    MemoryScore().solution(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni")
        )
    ).forEach {
        println(it)
    }

    MemoryScore().solution(
        arrayOf("kali", "mari", "don"),
        intArrayOf(11, 1, 55),
        arrayOf(
            arrayOf("kali", "mari", "don"), arrayOf("pony", "tom", "teddy"), arrayOf("con", "mona", "don")
        )
    ).forEach {
        println(it)
    }

    MemoryScore().solution(
        arrayOf("may", "kein", "kain", "radi"),
        intArrayOf(5, 10, 1, 3),
        arrayOf(
            arrayOf("may"), arrayOf("kein", "deny", "may"), arrayOf("kon", "coni")
        )
    ).forEach {
        println(it)
    }
}

class MemoryScore {

    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val answer = IntArray(photo.size) { 0 }

        val map = mutableMapOf<String, Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }

        for (i in photo.indices) {
            var sum = 0

            for (j in photo[i].indices) {
                sum += map[photo[i][j]] ?: 0
            }

            answer[i] = sum
        }

        return answer
    }
}