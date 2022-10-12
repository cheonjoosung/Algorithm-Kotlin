package pg.lv0

class SpaceAge {

    fun solution(age: Int): String {

        return (age.toString()).map {
            when (it) {
                '0' -> 'a'
                '1' -> 'b'
                '2' -> 'c'
                '3' -> 'd'
                '4' -> 'e'
                '5' -> 'f'
                '6' -> 'g'
                '7' -> 'h'
                '8' -> 'i'
                else -> 'j'
            }
        }.joinToString("")
    }
}