
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var firstPointer = l1
    var secondPointer = l2
    var mergedList = ListNode(0)
    var previous: ListNode? = mergedList

    while (firstPointer != null || secondPointer != null) {
        when {
            firstPointer?.`val` == null -> {
                previous?.next = secondPointer
                previous = secondPointer
                secondPointer = secondPointer?.next
            }
            secondPointer?.`val` == null -> {
                previous?.next = firstPointer
                previous = firstPointer
                firstPointer = firstPointer.next
            }
            firstPointer.`val` <= secondPointer.`val` -> {
                previous?.next = firstPointer
                previous = firstPointer
                firstPointer = firstPointer.next
            }
            secondPointer.`val` < firstPointer.`val` -> {
                previous?.next = secondPointer
                previous = secondPointer
                secondPointer = secondPointer.next
            }
        }
    }
    return mergedList.next
}

fun validateMergeTwoLists() {
    val head = ListNode(5)

    val head2 = ListNode(1)
    head2.next = ListNode(2)
    head2.next?.next = ListNode(4)

    val result = mergeTwoLists(head, head2)
    println(result)

}