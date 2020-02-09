import kotlin.test.assertFalse
import kotlin.test.assertTrue

// Time complexity : O(n)
// Space complexity : O(n)
fun palindromePermutation(word: String): Boolean {
    val charCount = HashSet<Char>()
    for (char in word) {
        val c = char.toLowerCase()
        if (c == ' ') continue
        if (charCount.contains(c)) {
            charCount.remove(c)
        } else {
            charCount.add(c)
        }
    }
    return charCount.size == 1 || charCount.isEmpty()
}

fun validatePalindromePermutation() {
    var test1 = "Tact Coa"
    var response1 = palindromePermutation(test1)
    assertTrue(response1)

    var test2 = "Tact Ca"
    var response2 = palindromePermutation(test2)
    assertTrue(response2)

    var test3 = "Tact Coar"
    var response3 = palindromePermutation(test3)
    assertFalse(response3)

    var test4 = " "
    var response4 = palindromePermutation(test4)
    assertTrue(response4)

    var test5 = ""
    var response5 = palindromePermutation(test5)
    assertTrue(response5)
}