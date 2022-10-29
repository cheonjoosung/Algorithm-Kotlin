package pg.lv0

class LoginSuccess {

    fun solution(id_pw: Array<String>, db: Array<Array<String>>): String {
        var answer: String = ""

        for (data in db) {
            val idOK = id_pw[0] == data[0]
            val pwOK = id_pw[1] == data[1]

            if (idOK) {
                if (pwOK) {
                    return "login"
                } else {
                    return "wrong pw"
                }
            } else {
                answer = "fail"
            }
        }
        return answer
    }
}