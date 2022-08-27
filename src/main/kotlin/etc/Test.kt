package etc

import java.math.BigInteger

data class User(
    val name: String,
    val age: Int,
    val favorite: Favorite
): Comparable<User> {

    override fun compareTo(other: User): Int {
        return compareValuesBy(this, other, {it.name}, {-it.age}, {it.favorite.number})
    }

}

enum class Favorite(val favorite: String, val number: Int) {
    BIKE("BIKE", 1), SWIM("SWIM", 2), YOUTUBE("YOUTUBE", 3)
}

fun main() {

    val list = mutableListOf<User>().apply {
        add(User("a", 15, Favorite.BIKE))
        add(User("a", 17, Favorite.BIKE))
        add(User("a", 15, Favorite.SWIM))
        add(User("ab", 15, Favorite.BIKE))
        add(User("b", 12, Favorite.SWIM))
        add(User("b", 11, Favorite.YOUTUBE))
        add(User("b", 12, Favorite.BIKE))
        add(User("bc", 15, Favorite.BIKE))
        add(User("c", 9, Favorite.BIKE))
        add(User("c", 5, Favorite.BIKE))
        add(User("c", 15, Favorite.YOUTUBE))
        add(User("a", 13, Favorite.BIKE))
    }

    list.sort()
    list.forEach { println(it) }
}