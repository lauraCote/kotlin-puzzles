fun productExceptSelf(nums: IntArray): IntArray {
    val length = nums.size

    val leftProducts = IntArray(length)
    leftProducts[0] = 1
    for (index in 1 until length) {
        leftProducts[index] = leftProducts[index - 1] * nums[index - 1]
    }

    val rightProducts = IntArray(length)
    rightProducts[length - 1] = 1
    for (index in length - 2 downTo 0) {
        rightProducts[index] = rightProducts[index + 1] * nums[index + 1]
    }

    val out = IntArray(length)
    for (index in 0 until length) {
        out[index] = leftProducts[index] * rightProducts[index]
    }

    return out
}