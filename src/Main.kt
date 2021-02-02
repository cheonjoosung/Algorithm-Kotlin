import pg.lv2.*

fun main () {
    val fmx = FormulaMax()

    println(fmx.solution("100-200*300-500+20")) //60420
    println(fmx.solution("50*6-3*2")) //300
}