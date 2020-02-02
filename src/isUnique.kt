
fun isUnique(s: String): Boolean {
    var chars = HashSet<Char>()
    for (char in s) {
        if (chars.contains(char)) {
            return false
        }
        chars.add(char)
    }
    return true
}