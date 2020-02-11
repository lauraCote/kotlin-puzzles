import java.lang.StringBuilder
import kotlin.test.assertEquals

fun compressString(input: String): String {
    if (input.length <= 1) {
        return input
    }

    var output = StringBuilder()
    var currentCount = 0
    var hasRepeats = false

    for (index in 0 until input.length) {
        currentCount++

        if (index + 1 >= input.length || input[index] != input[index + 1]) {
            output.append(input[index])
            output.append(currentCount)
            if (currentCount > 1) {
                hasRepeats = true
            }
            currentCount = 0
        }
    }

    if (!hasRepeats) {
        return input
    }

    return output.toString()
}

fun validateCompressString() {
    assertEquals("a3b3c3", compressString("aaabbbccc"))
    assertEquals("abc", compressString("abc"))
    assertEquals("a5b1c1", compressString("aaaaabc"))
    assertEquals("A2a4b1c1", compressString("AAaaaabc"))
}