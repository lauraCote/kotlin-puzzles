

fun main(args: Array<String>) {
    println("-- isUnique --")
    var input = "abcda"
    println(isUnique(input))

    println("-- checkPermutation --")
    var first = "abcda"
    var second = "dbafa"
    println(checkPermutations(first, second))

    println("-- spiralMatrix --")
    var intArray1 = intArrayOf(1)
    var intArray2 = intArrayOf(4)
    var intArray3 = intArrayOf(7)
    var array = arrayOf(intArray1, intArray2, intArray3)
    var response = spiralOrder(array)
    for (number in response) {
        println(number)
    }

}