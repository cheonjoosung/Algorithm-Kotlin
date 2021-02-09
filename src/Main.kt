import pg.lv1.CrainDoll
import pg.lv2.*

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


    //[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
    val board: Array<IntArray> = arrayOf(
        intArrayOf(
            0, 0, 0, 0, 0,
            0, 0, 1, 0, 3,
            0, 2, 5, 0, 1,
            4, 2, 4, 4, 2,
            3, 5, 1, 3, 1
        )
    )
    val move = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    val cd = CrainDoll()
    println("RES ${cd.solution(board, move)}")

}