import javax.swing.text.View

fun main () {

    val bankInterface = object : BankInterface {
        override fun account() {
            println("Interface Account")
        }
    }

    val bankClass = object : BankClass() {
        override fun account() {
            println("abstract Class Account")
        }
    }

    println(bankInterface.account())
    println(bankClass.account())
}

interface BankInterface {
    fun account()
}

abstract class BankClass {
    abstract fun account()
}