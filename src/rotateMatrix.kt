import kotlin.test.assertTrue

fun rotateMatrix(matrix: Array<IntArray>): Array<IntArray> {
    var n = matrix.size
    for (x in 0 until n / 2) {
        for (y in x until n - x - 1) {
            val temp = matrix[y][x]

            matrix[y][x] = matrix[n - 1 - x][y]

            matrix[n - 1 - x][y] = matrix[n - 1 - y][n - 1 - x]

            matrix[n - 1 - y][n - 1 - x] = matrix[x][n - 1 - y]

            matrix[x][n - 1 - y] = temp
        }
    }

    return matrix
}

fun validateRotateMatrix() {
    assertTrue(
        arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)
        ).contentDeepEquals(
            rotateMatrix(arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ))
        )
    )

    assertTrue(
        arrayOf(
            intArrayOf(13, 9, 5, 1),
            intArrayOf(14, 10, 6, 2),
            intArrayOf(15, 11, 7, 3),
            intArrayOf(16, 12, 8, 4)
        ).contentDeepEquals(
            rotateMatrix(arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16)
            ))
        )
    )
}

