fun spiralOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty()) {
        return IntArray(0)
    }

    var spiralArray = IntArray(matrix.size * matrix[0].size)

    var yLength = matrix.size - 1
    var xLength = matrix[0].size - 1
    var spiralIndex = 0
    var startXIndex = 0
    var startYIndex = 0

    while (startXIndex <= xLength && startYIndex <= yLength) {

        for (x in startXIndex .. xLength) {
            spiralArray[spiralIndex] = matrix[startYIndex][x]
            spiralIndex++
        }

        for (y in startYIndex + 1 .. yLength) {
            spiralArray[spiralIndex] = matrix[y][xLength]
            spiralIndex++
        }

        if (startXIndex < xLength && startYIndex < yLength) {
            for (x in (xLength - 1) downTo startXIndex) {
                spiralArray[spiralIndex] = matrix[yLength][x]
                spiralIndex++
            }

            for (y in (yLength - 1) downTo startYIndex + 1) {
                spiralArray[spiralIndex] = matrix[y][startXIndex]
                spiralIndex++
            }
        }

        xLength -= 1
        yLength -= 1
        startXIndex += 1
        startYIndex += 1
    }

    return spiralArray
}
