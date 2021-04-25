import backjun.s1.Bachu
import etc.Exchange
import etc.Train
import pg.lv2.CandidateKey
import pg.lv2.MenuRenewal
import java.util.*

fun main() {

    val ex = CandidateKey()
    var arr = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2")
    )
    println(ex.solution(arr))
}


