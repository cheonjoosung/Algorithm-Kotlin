package pg.lv0

fun main() {
    PictureEnlarge().solution(
        arrayOf(
            ".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."
        ), 2
    ).forEach { println(it) }

    PictureEnlarge().solution(
        arrayOf(
            "x.x", ".x.", "x.x"
        ), 3
    ).forEach { println(it) }
}

class PictureEnlarge {

    fun solution(picture: Array<String>, k: Int): Array<String> {
        val list = mutableListOf<String>()

        picture.forEach { str ->
            val sb = StringBuilder()

            str.forEach { ch ->
                repeat(k) {
                    sb.append(ch)
                }
            }

            repeat(k) {
                list.add(sb.toString())
            }
        }

        return list.toTypedArray()
    }
}