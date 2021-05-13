import pg.lv3.TripRoute

fun main() {

    val str: Array<Array<String>> = arrayOf(
        arrayOf("ICN", "JFK"),
        arrayOf("HND", "IAD"),
        arrayOf("JFK", "HND")
    )

    val str2 = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO"),
    )

    val a = TripRoute()

//    println(a.solution(str))

    val b = TripRoute()
    println(b.solution(str2))
}

