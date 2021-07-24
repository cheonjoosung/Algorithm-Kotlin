package pg.lv3

import java.util.*

class EditPyo {

    fun solution(n: Int, k: Int, cmd: Array<String>): String {

        var pos = k
        var remove = Stack<Int>()
        var size = n

        cmd.forEach {

            when (it[0]) {
                'U' -> pos -= it.substring(2).toInt()
                'D' -> pos += it.substring(2).toInt()
                'C' -> {
                    remove.add(pos)
                    size -= 1

                    if (pos == size)
                        pos -= 1
                }
                'Z' -> {
                    val idx = remove.pop()
                    size += 1

                    if (pos >= idx) pos += 1
                }
            }
        }

        val sb = StringBuilder()

        for (i in 0 until size) {
            sb.append('O')
        }

        while (remove.isNotEmpty()) {
            sb.insert(remove.pop(), 'X')
        }

        return sb.toString()
    }
}