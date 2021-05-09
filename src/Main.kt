import backjun.s1.Bachu
import etc.Exchange
import etc.Train
import pg.lv2.CandidateKey
import pg.lv2.MenuRenewal
import pg.lv2.RotateBracket
import pg.lv2.TargetNumber
import java.util.*

fun main() {

    val appleList = listOf(
        Apple("a++", 500),
        Apple("a+", 400),
        Apple("a", 300),
        Apple("b", 200),
        Apple("c", 100)
    )

    val applePrice = appleList.map { it.price }.fold(0, { total, next -> total + next })
    println("applePrice : ${applePrice}")


    val ex = RotateBracket()
    println(ex.solution( "[](){}"))
    println(ex.solution( "}]()[{"))
    println(ex.solution( "[)(]"))
    println(ex.solution( "}}}"))
}

data class Apple(val grade: String,val price: Int)

