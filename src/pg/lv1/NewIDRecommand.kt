package pg.lv1

class NewIDRecommand {
    private fun solution(new_id: String): String {
        var answer = new_id

        val reg = Regex("[a-z0-9-_.]")
        var reg2 = Regex("[.]{2,}")

        //1단계 소문자
        answer = answer.toLowerCase()
        var temp = StringBuilder()

        //2단계 숫자, -, _ ., 소문자 빼고 지우기
        for (i in answer.indices) {
            if (reg.containsMatchIn(answer[i].toString())) {
                temp.append(answer[i])
            }
        }

        answer = temp.toString()

        //3단계 연속된 . 2개 이상을 . 1개로
        answer = answer.replace(reg2, ".")

        //4단계 처음과 끝의 . 삭제
        if (answer.isNotEmpty() && answer.first() == '.') answer = answer.removeRange(0, 1)
        if (answer.isNotEmpty() && answer.last() == '.') answer = answer.removeRange(answer.length-1, answer.length)

        //5단계 빈 문자열이라면 "a"를 대입합니다.
        if (answer.isEmpty()) answer = "a"

        //6단계 길이 16이상이면 0~15까지만 살리고 나머지 제거. 제거후 마지막이 . 이거면 이것도 제거
        if (answer.length >= 16) {
            answer = answer.substring(0..14)

            if (answer.last() == '.') {
                answer = answer.removeRange(answer.length-1, answer.length)
            }
        }

        //7단계 길이가 2자 이하라면, 길이가 3이 될 때까지 마지막 문자 반복해서 끝에 붙입니다.
        while (answer.length <= 2) {
            answer = answer.plus(answer[answer.length-1])
        }

        return answer
    }
}