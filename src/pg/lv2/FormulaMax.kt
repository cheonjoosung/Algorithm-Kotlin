package pg.lv2

class FormulaMax {
    fun solution (expression: String): Long {
        var expPrior = arrayOf("*+-", "*-+", "-*+", "-+*", "+*-", "+-*")

        var answer: Long = 0
        /*
        1. * + - 에 총 몇개 있는지 파악하여 배열 만들기
        2. * + - 에 대한 우선순위를 완전탐색하는 경우의 수 생성
        3. 경우의 수에 따라 각 수식 계산
        "100-200*300-500+20" 60420
        "50*6-3*2" 300
        절대값이 가장 큰 값
         */

        var tokenNum = expression.split(Regex("[-+*]"))
        var tokenExp = expression.split(Regex("[0-9]+"))
        tokenExp = tokenExp.subList(1, tokenExp.size-1)

        for (expArr in expPrior.iterator()) {
            
        }

        return answer
    }

    fun cal(n1: Long, n2: Long, exp: Char) : Long {
        var res: Long = 0

        when (exp) {
            '*' -> res = n1*n2
            '-' -> res = n1-n2
            '+' -> res = n1+n2
        }

        return res
    }
}