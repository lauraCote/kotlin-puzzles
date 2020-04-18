import java.util.*
import kotlin.test.assertEquals

fun partition(node: ListNode?, x: Int): ListNode? {
    var head = node
    var tail = node
    var current: ListNode? = node

    while (current?.next != null) {
        val next = current.next
        if (current.`val` < x) {
            current.next = head
            head = current
        } else {
            tail?.next = current
            tail = current
        }
        current = next
    }

    tail?.next = null

    return head
}

