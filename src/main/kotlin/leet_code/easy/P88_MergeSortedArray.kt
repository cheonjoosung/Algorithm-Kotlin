package leet_code.easy

class P88_MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var j = 0
        for (i in m until m+n) {
            nums1[i] = nums2[j++]
        }

        nums1.sort()
    }
}

fun main() {
    P88_MergeSortedArray().merge(
        intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3
    )

    P88_MergeSortedArray().merge(
        intArrayOf(1), 1, intArrayOf(), 0)

    P88_MergeSortedArray().merge(
        intArrayOf(0), 0, intArrayOf(1), 1)
}