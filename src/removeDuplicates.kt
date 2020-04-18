import java.util.*
import kotlin.collections.HashSet
import kotlin.test.assertEquals

fun removeDuplicates(list: LinkedList<Int>): LinkedList<Int> {
    val seen = HashSet<Int>()
    val pointer = list.iterator()
    while (pointer.hasNext()) {
        val current = pointer.next()
        if (seen.contains(current)) {
            pointer.remove()
        } else {
            seen.add(current)
        }
    }
    return list
}

fun validateRemoveDuplicates() {
    assertEquals(
        LinkedList<Int>(listOf(1, 3, 2)),
        removeDuplicates(LinkedList(listOf(1, 3, 2, 3, 1)))
    )
}