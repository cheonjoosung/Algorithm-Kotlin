import pg.lv2.*

fun main () {
    val formulaMax = FormulaMax()

    val rankSearch = RankSearch()

    var info = arrayOf("java backend junior pizza 150","python frontend senior chicken 210",
        "python frontend senior chicken 150", "cpp backend senior pizza 260","java backend junior chicken 80",
        "python backend senior chicken 50")

    var query = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100",
        "- and - and - and - 150")
    //[1,1,1,1,2


    /*
     LV1~LV2 7문제 풀기
     조이스틱, 메뉴 리뉴얼, 순위 검색, 쿼드압 후 개수세기
     이진변환 반복, 수식 최대화, 후보키
     */
    println(rankSearch.solution(info, query))
}