package pg.lv2

import java.util.*


fun main() {
    DiscountEvent().solution(
        arrayOf("banana", "apple", "rice", "pork", "pot"),
        intArrayOf(3, 2, 2, 2, 1),
        arrayOf(
            "chicken",
            "apple",
            "apple",
            "banana",
            "rice",
            "apple",
            "pork",
            "banana",
            "pork",
            "rice",
            "pot",
            "banana",
            "apple",
            "banana"
        )
    ).also { println(it) } // 3
    DiscountEvent().solution(
        arrayOf("apple"),
        intArrayOf(10),
        arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana")
    ).also { println(it) } // 0
}

class DiscountEvent {

    private val USER_QUALIFICATION_DURATION = 10

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0

        //wantMap 초기화 및 필요한 상품 추가
        val wantMap: MutableMap<String, Int> = HashMap()
        for (i in want.indices) {
            val s = want[i]
            val count = number[i]
            wantMap[s] = count
        }

        //discountMap 초기화 및 처음 10일치의 상품 추가
        val discountMap: MutableMap<String, Int> = HashMap()
        for (i in 0 until USER_QUALIFICATION_DURATION) {
            val addItem = discount[i]
            discountMap[addItem] = discountMap.getOrDefault(addItem, 0) + 1
        }

        //처음 10일치의 상품이 추가된 상태에서 isEqual 메서드를 실행하여 answer의 값을 변경한다.
        if (isEqual(wantMap, discountMap)) {
            answer++
        }

        //두번째날부터는 삭제할 상품 과 추가할 상품을 지정하여 discountMap을 업데이트 하고
        //업데이트 된 내용을 바탕으로 isEqual 메서드를 실행하여 answer의 값을 변경한다.
        for (i in 1..discount.size - USER_QUALIFICATION_DURATION) {
            val deleteItem = discount[i - 1]
            discountMap[deleteItem] = discountMap[deleteItem]!! - 1
            val addItem = discount[i - 1 + USER_QUALIFICATION_DURATION]
            discountMap[addItem] = discountMap.getOrDefault(addItem, 0) + 1
            if (isEqual(wantMap, discountMap)) {
                answer++
            }
        }
        return answer
    }

    private fun isEqual(wantMap: Map<String, Int>, compareMap: Map<String, Int>): Boolean {
        for (key in wantMap.keys) {
            if (!compareMap.containsKey(key) || wantMap[key] !== compareMap[key]) {
                return false
            }
        }
        return true
    }
}