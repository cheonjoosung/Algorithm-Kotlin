package leet_code.easy

class P136_SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val cnt = map[nums[i]]!!
                map[nums[i]] = cnt + 1
            } else {
                map[nums[i]] = 1
            }
        }

        var answer = -1
        for (key in map.keys) {
            if (map[key] == 1) {
                answer = key
            }
        }

        return answer
    }
}

fun main() {
    P136_SingleNumber().singleNumber(intArrayOf(2,2,1)).also { println(it) }
    P136_SingleNumber().singleNumber(intArrayOf(4,1,2,1,2)).also { println(it) }
    P136_SingleNumber().singleNumber(intArrayOf(1)).also { println(it) }
}