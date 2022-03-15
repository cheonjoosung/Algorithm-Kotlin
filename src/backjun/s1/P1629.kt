package backjun.s1

import java.util.*

class P1629 {

    fun main() {

        val sc = Scanner(System.`in`)

        val a = sc.nextLong()
        val b = sc.nextLong()
        val c = sc.nextLong()

        println(pow(a, b, c))
    }

    // A^exponent
    fun pow(A: Long, exponent: Long, C: Long): Long {

        // 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
        if (exponent == 1L) {
            return A % C
        }

        // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
        val temp = pow(A, exponent / 2, C)

        /*
		 * 현재 지수가 홀 수 였다면
		 * A^(exponent / 2) * A^(exponent / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 *
		 * ex) A^9 = A^4 * A^4 * A
		 */return if (exponent % 2 == 1L) {
            temp * temp % C * A % C
        } else temp * temp % C
    }
}