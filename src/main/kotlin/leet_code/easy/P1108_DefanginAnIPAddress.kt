package leet_code.easy


class P1108_DefanginAnIPAddress {
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }
}

fun main() {
    P1108_DefanginAnIPAddress().defangIPaddr("1.1.1.1").also { println(it) }
}