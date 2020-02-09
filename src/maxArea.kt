import kotlin.math.min
import kotlin.test.assertEquals

fun maxArea(height: IntArray): Int {
    var startIndex = 0
    var endIndex = height.size - 1
    var area = endIndex - startIndex
    var max = 0

    while (area >= 1) {
        var current = min(height[startIndex], height[endIndex]) * area
        if (current > max) {
            max = current
        }
        if (height[startIndex] <= height[endIndex]) {
            startIndex++
        } else {
            endIndex--
        }
        area = endIndex - startIndex
    }

    return max
}

fun validateMaxArea() {
    var test1 = intArrayOf(1,8,6,2,5,4,8,3,7)
    var resp1 = maxArea(test1)
    var answer1 = 49
    assertEquals(answer1, resp1)

    var test2 = intArrayOf(1000,1000,6,2,5,4,8,3,7)
    var resp2 = maxArea(test2)
    var answer2 = 1000
    assertEquals(answer2, resp2)
}
