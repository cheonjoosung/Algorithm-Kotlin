import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val sb = StringBuilder()

    val n = sc.nextLong()
    val q = PriorityQueue<Long>()

    (1..n).forEach { _ ->
        val num = sc.nextLong()

        if (num == 0L) {
            sb.append(q.poll() ?: "0").append("\n")
        } else {
            q.add(num)
        }
    }

    println(sb.toString())
}