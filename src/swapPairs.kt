


fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    var pointer = head
    var nextHead = head.next
    var olderPointer: ListNode? = null

    while (pointer?.next != null) {
        var current = pointer
        var second = pointer.next
        current.next = current.next?.next
        second?.next = current
        pointer = current.next
        olderPointer?.next = second
        olderPointer = current
    }

    return nextHead
}

fun validateSwapPairs() {
    val node = ListNode(1)
    node.next = ListNode(2)
    node.next?.next = ListNode(3)
    node.next?.next?.next = ListNode(4)
    swapPairs(node)
}