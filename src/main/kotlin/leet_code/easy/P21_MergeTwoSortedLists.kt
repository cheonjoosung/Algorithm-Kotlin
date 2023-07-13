package leet_code.easy

class P21_MergeTwoSortedLists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        //list1?.next = list2

        val list = mutableListOf<Int>()

        var current = list1
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }

        var current2 = list2
        while (current2 != null) {
            list.add(current2.`val`)
            current2 = current2.next
        }

        list.sort()

        return if (list.isEmpty()) null
        else {
            val tempList = mutableListOf<ListNode>()
            for (i in list.indices) {
                tempList.add(ListNode(list[i]))
            }

            for (i in 1 until list.size) {
                tempList[i-1].next = tempList[i]
            }

            return tempList[0]
        }

    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val list1 = ListNode(1)
    val list2 = ListNode(2)
    val list3 = ListNode(3)
    list1.next = list2
    list2.next = list3

    val list4 = ListNode(1)
    val list5 = ListNode(1)
    val list6 = ListNode(1)
    list4.next = list5
    list5.next = list6
}