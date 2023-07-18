package leet_code.easy

class P35_SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val position = nums.indexOfFirst { it >= target }
        return if (position == -1)  nums.size
        else position
    }
}

fun main() {
    P35_SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 5).also { println(it) }
    P35_SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 2).also { println(it) }
    P35_SearchInsertPosition().searchInsert(intArrayOf(1,3,5,6), 7).also { println(it) }
}