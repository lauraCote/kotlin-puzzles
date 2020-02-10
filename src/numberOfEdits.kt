import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun oneEditReplace(word: String, editedWord: String): Boolean {
    var edits = 0
    for (index in word.indices) {
        if (word[index] != editedWord[index]) {
            edits++
        }
        if (edits > 1) {
            return false
        }
    }
    return true
}

fun oneEditInsert(first: String, second: String): Boolean {
    var firstIndex = 0
    var secondIndex = 0
    while (firstIndex < first.length && secondIndex < second.length) {
        if (first[firstIndex] != second[secondIndex]) {
            if (firstIndex != secondIndex) {
                return false
            }
            secondIndex++
        } else {
            secondIndex++
            firstIndex++
        }
    }
    return true
}

fun isOneEditAway(word: String, editedWord: String): Boolean {
    return when {
        word.length == editedWord.length -> {
            oneEditReplace(word, editedWord)
        }
        editedWord.length == word.length - 1 -> {
            oneEditInsert(editedWord, word)
        }
        editedWord.length == word.length + 1 -> {
            oneEditInsert(word, editedWord)
        }
        else -> false
    }
}

fun validateNumberOfEdits() {
    assertFalse(isOneEditAway("pale", "pl"))
    assertFalse(isOneEditAway("pale", "paless"))
    assertTrue(isOneEditAway("pale", "pales"))
    assertTrue(isOneEditAway("pale", "ple"))
    assertTrue(isOneEditAway("pale", "bale"))
    assertFalse(isOneEditAway("pale", "bala"))
    assertFalse(isOneEditAway("pale", "pas"))
}