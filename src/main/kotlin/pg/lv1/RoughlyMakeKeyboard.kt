package pg.lv1

fun main() {
    RoughlyMakeKeyboard().solution(keymap = arrayOf("ABACD", "BCEFD"), targets = arrayOf("ABCD", "AABB")).forEach { println(it) } //9,4
    //RoughlyMakeKeyboard().solution(keymap = arrayOf("AA"), targets = arrayOf("B")).forEach { println(it) } // -1
    //RoughlyMakeKeyboard().solution(keymap = arrayOf("AGZ", "BSSS"), targets = arrayOf("ASA", "BGZ")).forEach { println(it) } //4,6
}

class RoughlyMakeKeyboard {

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val list = mutableListOf<Int>()

        val map = hashMapOf<Char, Int>()
        for (i in keymap.indices) {
            for (j in keymap[i].indices) {
                val ch = keymap[i][j]
                if (map.containsKey(ch)) {
                    map[ch] = map[ch]!!.coerceAtMost(j + 1)
                } else {
                    map[ch] = j + 1
                }
            }
        }

        for (i in targets.indices) {
            var ans = 0

            for (j in targets[i].indices) {
                val ch = targets[i][j]

                if (map.containsKey(ch)) {
                    ans += map[ch]!!
                } else {
                    ans = 0
                    break
                }
            }

            if (ans == 0) list.add(-1) else list.add(ans)
        }

        return list.toIntArray()
    }
}