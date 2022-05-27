package pg.lv2

class TwoDigit {
    fun solution(s: String): IntArray {
        var answer = IntArray(2)

        var temp = s
        var cnt = 0
        var zero = 0

        while (temp != "1") {
            cnt++

            zero += temp.replace("1", "").length
            temp = temp.replace("0", "")
            temp = temp.length.toString(2)
        }

        answer[0] = cnt
        answer[1] = zero

        return answer
    }
}