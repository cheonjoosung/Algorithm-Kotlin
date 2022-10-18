package pg.lv0

class Dictionary {

    fun solution(spell: Array<String>, dic: Array<String>): Int {
        return if (dic.filter {
            (it.length == spell.size) && it.toCharArray().sorted().joinToString("").contentEquals(spell.sorted().joinToString(""))
        }.count() >= 1) 1 else 2
    }
}