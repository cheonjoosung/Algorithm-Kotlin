package backjun.g5

import java.util.*


fun main() {

    val sc = Scanner(System.`in`)

    val tc = sc.nextInt()

    (1..tc).forEach { _ ->
        val p = sc.next()
        val n = sc.nextInt()

        val arrStr: String = sc.next()
        val deque: Deque<Int> = LinkedList()

        for (s in arrStr.substring(1, arrStr.length - 1).split(",")
            .toTypedArray()) if (s != "") deque.add(Integer.valueOf(s))

        println(ac(deque, p))
    }

}

fun ac(deque: Deque<Int>, command: String): String {

    var reverse = false

    for (com in command.toCharArray()) {
        if (com == 'R') reverse = !reverse else {
            if (deque.size == 0) return "error"
            if (reverse) deque.removeLast() else deque.removeFirst()
        }
    }

    val sb = StringBuilder("[")
    while (!deque.isEmpty()) {
        sb.append(if (reverse) deque.removeLast() else deque.removeFirst())
        if (deque.size != 0) sb.append(',')
    }
    sb.append(']')

    return sb.toString()
}