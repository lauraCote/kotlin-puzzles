import java.lang.StringBuilder

fun checkPermutations(first: String, second: String): Boolean {
    if (first.length != second.length) {
        return false
    }

    var letters = IntArray(128)

    for (char in first) {
        letters[char.toInt()]++
    }

    for (char in second) {
        var charInt = char.toInt()
        letters[charInt]--
        if (letters[charInt] < 0) {
            return false
        }
    }
    return true
}

