import java.util.*


fun isPalindrome(head: ListNode?): Boolean {
    val nodes = Stack<Int>()
    var lengthPointer = head
    var totalLength = 0

    while (lengthPointer != null) {
        totalLength++
        lengthPointer = lengthPointer.next
    }

    var half = totalLength / 2
    var pointer = head

    for (index in 0 until half) {
        nodes.push(pointer?.`val`)
        pointer = pointer?.next
    }

    if (totalLength % 2 != 0) {
        half++
        pointer = pointer?.next
    }

    for (index in half until totalLength) {
        if (nodes.pop() != pointer?.`val`) {
            return false
        }
        pointer = pointer?.next
    }
    return true
}