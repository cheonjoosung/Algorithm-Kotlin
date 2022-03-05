import pg.lv3.TrackConstruction

fun main() {

    val str: String? = null

    str?.let {
        println("notNull")
    } ?: run {
        println("null")
    }

    println("hi")
}

