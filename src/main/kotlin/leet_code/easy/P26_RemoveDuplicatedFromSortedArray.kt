package leet_code.easy

class P26_RemoveDuplicatedFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        return if (nums.isEmpty()) 0
        else {
            var k = 1
            for (i in 1 until nums.size) {
                if (nums[i] != nums[i - 1]) {
                    nums[k++] = nums[i]
                }
            }
            k
        }
    }
}

fun main() {

}