fun checkValidString(s: String): Boolean {
    val parentheses = HashMap<Char, Int>()
    for (character in s) {
        if (character == '(' || character == '*') {
            addCharacter(character, parentheses)
        } else if (character == ')') {
            if (parentheses.containsKey('(')){
                updateCharacter('(', parentheses)
            } else if (parentheses.contains('*')) {
                updateCharacter('*', parentheses)
            } else {
                return false
            }
        }
    }

    if (parentheses.containsKey('*')) {
        val count = parentheses.getValue('*')
        for (i in 0 until count) {
            if (parentheses.containsKey('(')) {
                updateCharacter('(', parentheses)
            }
        }
        parentheses.remove('*')
    }

    return parentheses.isNullOrEmpty()
}

fun addCharacter(c: Char, map: HashMap<Char, Int>) {
    if (map.containsKey(c)) {
        val count = map.getValue(c)
        map[c] = count + 1
    } else {
        map[c] = 1
    }
}

fun updateCharacter(c: Char, map: HashMap<Char, Int>) {
    val count = map.getValue(c) - 1
    if (count == 0) {
        map.remove(c)
    } else {
        map[c] = count
    }
}

fun validateCheckValidString() {
    var str = "(())((())()()(*)(*()(())())())()()((()())((()))(*"
    println(checkValidString(str))
}