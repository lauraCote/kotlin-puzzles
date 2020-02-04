import kotlin.test.assertTrue

fun URLify(input: CharArray): CharArray {
    if (input.isEmpty()) {
        return CharArray(0)
    }

    var lastIndex = input.size - 1
    while (lastIndex > 0 && input[lastIndex] == ' ') {
        lastIndex--
    }

    var url = CharArray(input.size)
    var urlIndex = 0
    for (index in 0 .. lastIndex) {
        if (input[index] == ' ') {
            url[urlIndex] = '%'
            urlIndex++
            url[urlIndex] = '2'
            urlIndex++
            url[urlIndex] = '0'
            urlIndex++
        } else {
            url[urlIndex] = input[index]
            urlIndex++
        }
    }
    return url
}

fun validateURLify() {
    var test1 = charArrayOf('T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'i', 't', ' ', ' ', ' ', ' ')
    var resp1 = URLify(test1)
    var answer1 = charArrayOf('T', 'h', 'i', 's', '%', '2', '0', 'i', 's', '%', '2', '0', 'i', 't')
    assertTrue(resp1.contentEquals(answer1))

    var test3 = charArrayOf(' ', ' ', ' ')
    var resp3 = URLify(test3)
    var answer3 = charArrayOf('%', '2', '0')
    assertTrue(resp3.contentEquals(answer3))

    var test4 = charArrayOf('t', 'h', 'i', 's', 'i', 's', 'i', 't')
    var resp4 = URLify(test4)
    var answer4 = charArrayOf('t', 'h', 'i', 's', 'i', 's', 'i', 't')
    assertTrue(resp4.contentEquals(answer4))
}