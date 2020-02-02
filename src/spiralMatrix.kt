fun spiralOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty()) {
        return IntArray(0)
    }

    if (matrix.size == 1) {
        return matrix.first()
    }

    var yLength = matrix.size
    var xLength = matrix[0].size
    var spiralArray = IntArray(xLength * yLength)
    var spiralIndex = 0
    var startXIndex = 0
    var startYIndex = 0

    while ((xLength - startXIndex) > 0 && (yLength - startYIndex) > 0) {

        for (x in startXIndex until xLength) {
            spiralArray[spiralIndex] = matrix[startYIndex][x]
            spiralIndex++
        }

        for (y in startYIndex + 1 until yLength) {
            spiralArray[spiralIndex] = matrix[y][xLength - 1]
            spiralIndex++
        }

        for (x in (xLength - 2) downTo startXIndex) {
            spiralArray[spiralIndex] = matrix[yLength - 1][x]
            spiralIndex++
        }

        for (y in (yLength - 2) downTo startYIndex + 1) {
            spiralArray[spiralIndex] = matrix[y][startXIndex]
            spiralIndex++
        }

        xLength -= 1
        yLength -= 1
        startXIndex += 1
        startYIndex += 1
    }

    return spiralArray
}
