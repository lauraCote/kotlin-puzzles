import kotlin.math.abs
import kotlin.test.assertEquals

fun firstMissingPositive(nums: IntArray): Int {
    var oneExists = false

    for (num in nums) {
        if (num == 1) {
            oneExists = true
        }
    }

    if (!oneExists) {
        return 1
    }

    for (index in nums.indices) {
        if (nums[index] <= 0 || nums[index] > nums.size) {
            nums[index] = 1
        }
    }

    for (index in nums.indices) {
        val ind = abs(nums[index])
        if (ind == nums.size) {
            nums[0] = -1 * abs(nums[0])
        } else {
            nums[ind] = -1 * abs(nums[ind])
        }
    }

    for (index in 1 until nums.size) {
        if (nums[index] > 0) {
            return index
        }
    }

    if (nums[0] > 0) {
        return nums.size
    }

    return nums.size + 1
}

fun validateFirstMissingPositive() {
    assertEquals(firstMissingPositive(intArrayOf(1, 2, 0)), 3)
    assertEquals(firstMissingPositive(intArrayOf(3, 4, -1, 1)), 2)
    assertEquals(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)), 1)
    assertEquals(firstMissingPositive(intArrayOf(0, 2, 1, 4, 7)), 3)
}