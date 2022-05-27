import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val arr = arrayOf("hi", "bye", "ki").forEach { println(it) }
//    println(arr.contentToString())
}

suspend fun wwprintln() {
    delay(2000L)
    println("hihihio")
}

suspend fun sum(): Int = coroutineScope {
    val one = async { doOne() }
    val two = async { doTwo() }

    one.await() + two.await()
}

suspend fun doOne(): Int {
    println("Start one")
    delay(1000L)
    println("End one")
    return 13
}

suspend fun doTwo(): Int {
    println("Start Two")
    delay(1000L)
    println("End two")
    return 29
}

fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}
