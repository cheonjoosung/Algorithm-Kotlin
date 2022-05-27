package structure

import java.util.*
import kotlin.collections.ArrayList

class Polymorphism {
    fun code() {

        //부모로 선언하고 자신으로 참조하는 이유
        //DI 및 다형성과 관련되어 있음.
        val list: List<Int> = ArrayList<Int>()
        val vector: List<Int> = Vector<Int>()
        val arrayList: ArrayList<Int> = ArrayList<Int>()

        method1(list)
        method1(vector)
        method1(arrayList)

//        method2(list)
//        method2(vector)
        method2(arrayList)
    }


    fun method1(list: List<Int>) {}

    fun method2(list: ArrayList<Int>) {}
}