package pg.lv0

class PasswordDecode {

    fun solution(cipher: String, code: Int): String {
        var answer: String = ""
        return cipher.filterIndexed { index, c ->  (index+1) % code == 0}
    }
}