import backjun.g3.Bitonic
import backjun.g3.Panda
import backjun.p1000_1999.PrintQueue
import pg.lv1.CrainDoll
import pg.lv1.SecretMap
import pg.lv2.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private val answer = 4
fun main() {
    /*
     LV1~LV2 7문제 풀기
     조이스틱, 메뉴 리뉴얼, 순위 검색, 쿼드압 후 개수세기, 후보키
     */
    val c = CandidateKey()
    val arr: Array<Array<String>> = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2")
    )
    /*[
        ["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],
        ["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]
    ]*/

    //println(c.solution(arr)) //2
    val sm = SecretMap()
    println(
        sm.solution(
            n = 5,
            arr1 = arrayOf(9, 20, 28, 18, 11),
            arr2 = arrayOf(30, 1, 21, 17, 28)
        )
    )

    println(
        sm.solution(
            n = 6,
            arr1 = arrayOf(46, 33, 33 ,22, 31, 50),
            arr2 = arrayOf(27 ,56, 19, 14, 14, 10)
        )
    )

}

