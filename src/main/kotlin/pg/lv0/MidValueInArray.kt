package pg.lv0

class MidValueInArray {

    fun solution(array: IntArray): Int {
        return array.sortedArray().mid()
    }
}

fun IntArray.mid(): Int {
    return this[size/2]
}