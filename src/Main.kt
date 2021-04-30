import backjun.s1.Bachu
import etc.Exchange
import etc.Train
import pg.lv2.CandidateKey
import pg.lv2.MenuRenewal
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


    val ex = TargetNumber()
    val arr = intArrayOf(1, 1, 1, 1, 1)
    println(ex.solution(arr, -3))

}

data class Apple(val grade: String,val price: Int)

