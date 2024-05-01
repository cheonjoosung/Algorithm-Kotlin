package pg.lv1

fun main() {
    ManyGift().solution(
        arrayOf("muzi", "ryan", "frodo", "neo"),
        arrayOf(
            "muzi frodo",
            "muzi frodo",
            "ryan muzi",
            "ryan muzi",
            "ryan muzi",
            "frodo muzi",
            "frodo ryan",
            "neo muzi"
        )
    ).also { println(it) } //2

    ManyGift().solution(
        arrayOf("joy", "brad", "alessandro", "conan", "david"),
        arrayOf(
            "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"
        )
    ).also { println(it) } //4

    ManyGift().solution(
        arrayOf("a", "b", "c"),
        arrayOf(
            "a b", "b a", "c a", "a c", "a c", "c a"
        )
    ).also { println(it) } //0
}

class ManyGift {

    fun solution(friends: Array<String>, gifts: Array<String>): Int {

        val gift = Array(friends.size) { IntArray(friends.size) { 0 } }
        val giftIndex = IntArray(friends.size) { 0 }

        for (g in gifts) {
            val token = g.split(" ")
            val give = token[0]
            val receive = token[1]

            val giveIndex = friends.indexOf(give)
            val receiveIndex = friends.indexOf(receive)

            giftIndex[giveIndex]++
            giftIndex[receiveIndex]--
            gift[giveIndex][receiveIndex]++
        }

        val answer = IntArray(friends.size) { 0 }

        for (i in gift.indices) {
            for (j in gift[0].indices) {
                if (i == j) continue

                // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                if ((gift[i][j] == 0 && gift[j][i] == 0) || gift[i][j] == gift[j][i]) {
                    if (giftIndex[i] > giftIndex[j]) {
                        answer[i]++
                    }
                } else { // 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                    if (gift[i][j] > gift[j][i]) {
                        answer[i]++
                    }
                }
            }
        }

        return answer.maxOf { it }
    }
}