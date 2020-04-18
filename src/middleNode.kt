import kotlin.test.assertNotEquals

fun middleNode(head: ListNode?): ListNode? {
    var pointerLength = head
    var pointerMiddle = head
    var length = 0

    while (pointerLength != null) {
        pointerLength = pointerLength.next
        length++
    }

    var middle = length / 2 + 1

    for(i in 2..middle) {
        pointerMiddle = pointerMiddle?.next
    }

    return pointerMiddle
}

fun validateMiddleNode() {
    var test = ListNode(1)
    test.next = ListNode(2)
    test.next?.next = ListNode(3)
    test.next?.next?.next = ListNode(4)
    test.next?.next?.next?.next = ListNode(5)
    test.next?.next?.next?.next?.next = ListNode(6)
    var node = middleNode(test)
    println(node?.`val`)
}