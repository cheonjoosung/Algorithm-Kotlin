package leet_code.easy

class P83_RemoveDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val set = mutableSetOf<Int>()

        var current = head

        while (current != null) {
            set.add(current.`val`)
            current = current.next
        }

        return if (set.isEmpty()) null
        else {
            val tempList = mutableListOf<ListNode>()
            for (item in set) {
                tempList.add(ListNode(item))
            }

            for (i in 1 until tempList.size) {
                tempList[i - 1].next = tempList[i]
            }

            return tempList[0]
        }
    }
}

fun main() {
    val a1 = ListNode(1)
    val a2 = ListNode(1)
    val a3 = ListNode(2)
    a1.next = a2
    a2.next = a3
}