

fun singleNumber(nums: IntArray): Int {
    for (index in 1 until nums.size) {
        nums[0] xor nums[index]
    }
    return nums[0]
}

fun validateSingleNumber() {
    var test1 = intArrayOf(-1)
    var result = singleNumber(test1)
    println(result)
}