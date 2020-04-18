import java.util.*

fun reverseList(head: ListNode?): ListNode? {
    var previous: ListNode? = null
    var current = head
    var next = head?.next

    while (current != null) {
        current.next = previous
        previous = current
        current = next
        next = next?.next
    }

    return previous
}

// RECURSIVE
//fun reverseList(head: ListNode?): ListNode? {
//    if (head == null) {
//        return null
//    }
//    if (head.next == null) {
//        return head
//    }
//    val p = reverseList(head.next)
//    head.next?.next = head
//    head.next = null
//    return p
//}

fun validateReversedList() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
//    head.next?.next?.next = ListNode(4)
//    head.next?.next?.next?.next = ListNode(5)
    val result = reverseList(head)
    println(result)
}