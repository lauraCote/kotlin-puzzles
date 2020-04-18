import kotlin.test.assertEquals


fun findDuplicate(nums: IntArray): Int {
    var num1 = nums[0]
    var num2 = nums[0]

    do {
        num1 = nums[num1]
        num2 = nums[nums[num2]]
    } while (num1 != num2)

    var ptr1: Int = nums[0]
    var ptr2: Int = num1
    while (ptr1 != ptr2) {
        ptr1 = nums[ptr1]
        ptr2 = nums[ptr2]
    }

    return ptr1
}

fun validateFindDuplicate() {
    assertEquals(2, findDuplicate(intArrayOf(1,3,4,2,2)))
    assertEquals(3, findDuplicate(intArrayOf(1,3,4,3,2)))
    assertEquals(7, findDuplicate(intArrayOf(6,1,3,7,4,5,2,7)))
    assertEquals(9, findDuplicate(intArrayOf(2,5,9,6,9,3,8,9,7,1)))
}
