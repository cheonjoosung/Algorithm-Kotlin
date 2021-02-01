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

    println(rankSearch.solution(info, query))
}