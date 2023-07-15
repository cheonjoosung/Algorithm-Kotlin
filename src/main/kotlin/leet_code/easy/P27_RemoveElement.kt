package leet_code.easy

class P27_RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.size - 1
        var count = 0

        while (left <= right) {
            if (nums[left] == `val`) {
                nums[left] = nums[right]
                right--
            } else {
                left++
                count++
            }
        }

        return count
    }
}

fun main() {
    P27_RemoveElement().removeElement(intArrayOf(3,2,2,3), 3)
    //P2_RemoveElement().removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2)
}