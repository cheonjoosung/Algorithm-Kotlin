package pg.lv0

class MosSignal {

    val hashMap = hashMapOf<String, String>(
        ".-" to "a","-..." to "b","-.-." to "c","-.." to "d","." to "e","..-." to "f",
    "--." to "g","...." to "h",".." to "i",".---" to "j","-.-" to "k",".-.." to "l",
    "--" to "m","-." to "n","---" to "o",".--." to "p","--.-" to "q",".-." to "r",
    "..." to "s","-" to "t","..-" to "u","...-" to "v",".--" to "w","-..-" to "x",
    "-.--" to "y","--.." to "z"
    )

    fun solution(letter: String): String {

        val token = letter.split(" ")
        val sb = StringBuilder()

        for (key in  token) {
            sb.append(hashMap[key])
        }

        return sb.toString()
    }
}