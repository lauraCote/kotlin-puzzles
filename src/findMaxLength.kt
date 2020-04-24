fun findMaxLength(nums: IntArray): Int {
    var counts = HashMap<Int, Int>()
    var count = 0
    var maxLength = 0
    counts.put(count, 0)
    for (index in nums.indices) {
        count += if (nums[index] == 0) -1 else 1
        if (counts.containsKey(count)) {
            var otherIndex = counts.get(count)
            if (otherIndex != null) {
                var length = index - otherIndex + 1
                if (length > maxLength) {
                    maxLength = length
                }
            }
        } else {
            counts.put(count, index + 1)
        }
    }
    return maxLength
}

fun validateFindMaxLength() {
    var test1 = intArrayOf(0, 1, 0, 1, 1, 1, 0, 1, 0, 1)
    var resp1 = findMaxLength(test1)
    println(resp1)
}