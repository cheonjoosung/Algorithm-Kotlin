import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val tc = sc.nextInt()

    val sb = StringBuilder()

    (1..tc).forEach { _ ->
        val n = sc.nextInt()

        /**
         * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중
         * 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
         * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
         */
        var cnt = 1

        val arr = IntArray(n + 1) { 0 }

        for (i in 0 until n) {
            val x = sc.nextInt()
            val y = sc.nextInt()

            arr[x] = y
        }

        /**
         * x는 오름차순으로 설정
         * x가 1인 사람은 무조건 합격
         * x가 2인 사람은 x가 1인 사람보다 y가 작으면 합격 && 합격시 y가 기준점
         */
        var base = arr[1]
        for (i in 2..n) {
            if (base > arr[i]) {
                cnt++
                base = arr[i]
            }
        }

        sb.append(cnt).append("\n")
    }

    println(sb.toString())
}