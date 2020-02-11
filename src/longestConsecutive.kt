import kotlin.test.assertEquals

fun longestConsecutive(nums: IntArray): Int {
    val hashNums = HashSet<Int>()

    for (num in nums) {
        hashNums.add(num)
    }

    var longuestStreak = 0

    for (num in nums) {
        if (!hashNums.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1

            while (nums.contains(currentNum + 1)) {
                currentStreak++
                currentNum++
            }

            longuestStreak = Math.max(currentStreak, longuestStreak)
        }
    }

    return longuestStreak

}

fun validateLongestConsecutive() {
    assertEquals(4, longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    assertEquals(3, longestConsecutive(intArrayOf(102, 101, 1, 100, 9, 10)))
}