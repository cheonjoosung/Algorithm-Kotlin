import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val used = BooleanArray(2000001)

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = IntArray(n) { 0 }

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        s[i] = st.nextToken().toInt()
    }

    for (i in 0 until (1 shl n)) {
        var sum = 0
        for (j in 0 until n) {
            if (i and (1 shl j) != 0) {
                sum += s[j]
            }
        }
        used[sum] = true
    }

    var ans = 0
    for (i in 1 until used.size) {
        if (!used[i]) {
            ans = i
            break
        }
    }
    println(ans)
    br.close()

}