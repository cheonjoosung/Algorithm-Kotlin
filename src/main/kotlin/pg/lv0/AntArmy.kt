package pg.lv0

class AntArmy {

    fun solution(hp: Int): Int {
        var answer: Int = 0

        var temp = hp
        answer += temp/5
        temp %= 5
        answer += temp/3
        temp %= 3
        answer += temp

        return answer
    }
}