fun countElements(arr: IntArray): Int {
    var count = 0
    var index = 0
    arr.sort()
    while (index < arr.size - 1) {
        val nextValue = arr[index] + 1
        var nextIndex = index + 1

        while (nextIndex < arr.size && arr[nextIndex] == arr[index]) {
            nextIndex++
        }

        if (nextIndex < arr.size && arr[nextIndex] == nextValue) {
            count++
        }
        index++
    }
    return count
}

fun validateCountElements() {
    var test1 = intArrayOf(1,1,2,2)
    var result = countElements(test1)
    println(result)
}