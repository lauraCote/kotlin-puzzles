import kotlin.math.max
import kotlin.test.assertEquals

fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    var localMax = nums[0]
    var globalMax = localMax

    for (index in 1 until nums.size) {
        localMax = max(nums[index], nums[index] + localMax)
        if (localMax > globalMax) {
            globalMax = localMax
        }
    }

    return globalMax
}

fun validateMaxSubArray() {
    val test1 = intArrayOf(-2, 5, -3, 4, -1, 2, 1, -5, 4)
    assertEquals(8, maxSubArray(test1))
}