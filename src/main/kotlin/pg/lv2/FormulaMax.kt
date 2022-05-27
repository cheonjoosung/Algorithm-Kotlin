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
            var tempTokenNum = tokenNum.toMutableList()
            var tempTokenExp = tokenExp.toMutableList()

            for (exp in expArr) {
                while (tempTokenExp.indexOf((exp.toString())) != -1) {
                    val idx = tempTokenExp.indexOf(exp.toString())

                    /*
                    1.tokenNum 에서 idx & idx+1 를 계산 후 tokenNum 재수정
                    2.tokenExp또 빠졌으니까 해당 인덱스 지우기
                     (100, 200, 300, 500) (- + *) idx=1 exp=+ => (100, 300, 500) (-, *)
                     */
                    val first = tempTokenNum[idx].toLong()
                    val second = tempTokenNum[idx+1].toLong()

                    val res = cal(first, second, exp)

                    tempTokenNum[idx]= res.toString()
                    tempTokenNum.removeAt(idx+1)
                    tempTokenExp.removeAt(idx)
                }
            }

            if (tempTokenNum.size == 1)
                answer = Math.max(answer, Math.abs(tempTokenNum[0].toLong()))
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