package pg.lv2

class MagicElevator {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var temp = storey

        /**
         * 1~4 -> 0, 6~9 -> 10, 5인 경우 앞자리가 1~4인지, 5~9인지 체크
         */
        while (temp > 0) {
            val ext = temp % 10
            temp /= 10

            answer += if (ext == 5) {
                if (temp % 10 >= 5) {
                    temp++
                    10 - ext
                } else {
                    ext
                }
            } else if (ext > 5) {
                temp++
                10 - ext
            } else {
                ext
            }
        }

        return answer
    }
}

fun main() {
    MagicElevator().solution(16).also { println(it) } //6
    //-1, +100이 적힌 버튼을 4번, +10이 적힌 버튼을 5번, -1000이 적힌 버튼을 3번 누르면 0층에 도착 할 수 있습니다. 그러므로 16을 return 합니다.
    MagicElevator().solution(2554).also { println(it) } //16 0층..
    // -1 4번 2550 -> 10 5번 2600 -> 100 4번 3000 -> -1000 3번 0
}