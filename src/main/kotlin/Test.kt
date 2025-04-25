import javax.swing.text.View


fun main() {
    val park = Park()
    park.solution(
        intArrayOf(5, 3, 2),
        arrayOf(
            arrayOf("A", "A", "-1", "B", "B", "B", "B", "-1"),
            arrayOf("A", "A", "-1", "B", "B", "B", "B", "-1"),
            arrayOf("-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"),
            arrayOf("-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"),
            arrayOf("D", "D", "-1", "-1", "-1", "-1", "E", "-1"),
            arrayOf("D", "D", "-1", "-1", "-1", "-1", "-1", "F"),
            arrayOf("D", "D", "-1", "-1", "-1", "-1", "-1", "F")
        )
    ).also { println(it) }
}