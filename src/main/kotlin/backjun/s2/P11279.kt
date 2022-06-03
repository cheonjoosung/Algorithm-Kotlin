import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val tc = sc.nextInt()

    val sb = StringBuilder()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    (1..tc).forEach { _ ->
        val num = sc.nextInt()

        if (num == 0) {
            sb.append(pq.poll() ?: "0").append("\n")
        } else {
            pq.add(num)
        }
    }

    print(sb.toString())
    sc.close()
}