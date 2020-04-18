
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var dummyNode = ListNode(0)
    dummyNode.next = head
    var firstPointer: ListNode? = dummyNode
    var secondPointer: ListNode? = dummyNode
    var index = 1

    while (index <= n + 1) {
        firstPointer = firstPointer?.next
        index++
    }

    while (firstPointer != null) {
        secondPointer = secondPointer?.next
        firstPointer = firstPointer.next
    }

    secondPointer?.next = secondPointer?.next?.next

    return dummyNode.next
}

fun validateRemoveNthFromEnd() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    removeNthFromEnd(head, 1)
}