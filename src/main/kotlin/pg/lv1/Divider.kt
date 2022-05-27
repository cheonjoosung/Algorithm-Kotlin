package pg.lv1

class Divider {
    private fun solution(n: Int): Int {
        var answer = 0

        /*
        let =
        var =
         */

        /*
        1번 방식
         */
        answer = (1..n).filter { n % it == 0 }.sum()


        /* 2번 방식
            n = 9 -> half 3        3*3 = 9
            n = 14 -> half 3.xx    3*3 = 9   4*4 = 16
            n = 26 -> half 6.xxx   6*6 = 36
         */
        val half = Math.sqrt(n.toDouble()).toInt()

        for (i in 1..half) {
            if (n % i == 0) {
                answer += i
                if (i != n / i) answer += n / i
            }
        }

        return answer
    }

    fun isNotPrimeNumberPrev(n: Int) {
        for (i in 2..n) {
            var isPrime = true

            for (j in 2 until i) {
                if (i % j == 0)  {
                    isPrime = false
                    continue
                }
            }

            if (isPrime) print("소수")
        }
    }

    //소수 구하기  n*n의 시간복잡도가 나는 경우
    fun isNotPrimeNumber(n: Int) {
        val isNotPrimeNumber = BooleanArray(n+1) //소수가 아닌것을 체크하기 위해서

        isNotPrimeNumber[0] = true  // 0은 소수 아님
        isNotPrimeNumber[1] = true  // 1도 소수 아님

        for (i in 2..n) {
            if (isNotPrimeNumber[i]) continue //중복을 체크하기 위해 true 인것은 패스

            /*
                배수 개념 활용 (i * j)
                2*2 2*3 2*4 2*5 2*6 .......... 은 다 소수가 아님 약수를 가지므로
                3*2[중복] 3*4 3*5 3*6 .......... 은 다 소수가 아님 약수를 가지므로
                4*2[중복] 4*3[중복] 4*4
                .....
                10만까지 하면 끝 기존의 로직보다 대각선으로 표시된 [중복]을 안하므로 시간 많이 줄일 수 있음
             */
            for (j in 2..n) {               //배수 개념 활용
                if (i * j > n) break
                isNotPrimeNumber[j*i] = true
            }
        }
    }

}