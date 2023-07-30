package leet_code.easy

class P169_MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var majority: Int? = null // 주요 요소를 저장할 변수
        var count = 0 // 주요 요소의 등장 횟수를 저장할 변수

        for (num in nums) {
            if (count == 0) {
                // 현재 주요 요소가 없는 경우 새로운 요소로 설정
                majority = num
            }
            if (num == majority) {
                // 현재 요소가 주요 요소와 같은 경우 카운트 증가
                count++
            } else {
                // 현재 요소가 주요 요소와 다른 경우 카운트 감소
                count--
            }
        }

        // 주요 요소가 항상 존재하므로 마지막에 majority에 저장된 값이 주요 요소입니다.
        return majority!!
    }
}

fun main() {
    P169_MajorityElement().majorityElement(intArrayOf(3,2,3)).also { println(it) }
    P169_MajorityElement().majorityElement(intArrayOf(2,2,1,1,1,2,2)).also { println(it) }
}