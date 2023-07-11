package leet_code.easy

class P01_TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val answer = intArrayOf(0, 1)
        for (i in nums.indices) {
            var isFind = false

            for (j in i + 1 until nums.size) {

                if (nums[i] + nums[j] == target) {
                    isFind = true
                    answer[0] = i
                    answer[1] = j
                    break
                }

            }

            if (isFind) {
                break
            }
        }

        return answer
    }
}

fun main() {

}