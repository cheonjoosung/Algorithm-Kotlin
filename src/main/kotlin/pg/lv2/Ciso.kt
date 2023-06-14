package pg.lv2

class Ciso {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0

        // 2, 3 ,4
        // weights 길이는 100,000
        // 100,000 C 6
        // 100, 180, 360, 100 ,270
        // (a,b,c) (d,e,f) => a*4 + b*3 + 2*c = 2*d + 3*e + 4*f

        weights.sort()
        for (i in weights.indices) {
            for (j in i+1 until weights.size) {
                if (weights[i] == weights[j]) {
                    answer++
                    continue
                }

                if (weights[i] * 2 == weights[j]) {
                    answer++
                    continue
                }

                if (weights[i]*3 == weights[j]*2) {
                    answer++
                    continue
                }

                if (weights[i]*4 == weights[j]*3) {
                    answer++
                    continue
                }
            }
        }

        return answer
    }
}

fun main() {
    Ciso().solution(intArrayOf(100, 180, 360, 100 ,270)).also { println(it) }
}