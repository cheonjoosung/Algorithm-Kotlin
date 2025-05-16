package backjun.b

fun main() {
    when (val n = readln().toInt()) {
        0 -> println(0)
        1 -> println(1)
        else -> {
            val arr = LongArray(n + 1)
            arr[0] = 0
            arr[1] = 1

            for (i in 2..n) {
                arr[i] = arr[i - 1] + arr[i - 2]
            }
            println(arr[n])
        }
    }
}