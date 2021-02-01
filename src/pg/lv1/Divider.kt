package pg.lv1

class Divider {
    private fun solution(n: Int): Int {
        var answer = 0

        //answer = (1..12).filter { n % it == 0 }.sum()

        for (i in 1..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                answer += i
                if (i != n / i) answer += n / i
            }
        }

        return answer
    }
}