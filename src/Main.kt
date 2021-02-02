import pg.lv2.*

fun main () {
    val td = TwoDigit()

    println(td.solution("110010101001")) //60420
    println(td.solution("01110")) //300
    println(td.solution("1111111")) //300
}