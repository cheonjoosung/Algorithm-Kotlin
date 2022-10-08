package pg.lv0

class ArrayLength {

    fun solution(strlist: Array<String>): IntArray {
        return strlist.map { it.length }.toIntArray()
    }
}