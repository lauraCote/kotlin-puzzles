

fun main(args: Array<String>) {
    println("-- isUnique --")
    var input = "abcda"
    println(isUnique(input))

    println("-- checkPermutation --")
    var first = "abcda"
    var second = "dbafa"
    println(checkPermutations(first, second))

    println("-- spiralMatrix --")
    var intArray1 = intArrayOf(1, 2, 3, 4)
    var intArray2 = intArrayOf(5, 6, 7, 8)
    var intArray3 = intArrayOf(9, 10, 11, 12)
    var intArray4 = intArrayOf(13, 14, 15, 16)
    var intArray5 = intArrayOf(17, 18, 19, 20)
    var array = arrayOf(intArray1, intArray2, intArray3, intArray4, intArray5)
    var response = spiralOrder(array)
    for (number in response) {
        println(number)
    }

    validateURLify()
}