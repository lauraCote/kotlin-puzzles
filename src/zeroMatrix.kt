import kotlin.test.assertTrue

fun nullifyRow(matrix: Array<IntArray>, row: Int) {
    for (j in matrix[0].indices) {
        matrix[row][j] = 0
    }
}

fun nullifyColumn(matrix: Array<IntArray>, column: Int) {
    for (i in matrix.indices) {
        matrix[i][column] = 0
    }
}

fun zeroMatrix(matrix: Array<IntArray>): Array<IntArray> {
    var rowHasZero = false
    var columnHasZero = false

    for (j in matrix[0].indices) {
        if (matrix[0][j] == 0) {
            rowHasZero = true
            break
        }
    }

    for (i in matrix.indices) {
        if (matrix[i][0] == 0) {
            columnHasZero = true
            break
        }
    }

    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (i in 1 until matrix.size) {
        if (matrix[i][0] == 0) {
            nullifyRow(matrix, i)
        }
    }

    for (j in 1 until matrix[0].size) {
        if (matrix[0][j] == 0) {
            nullifyColumn(matrix, j)
        }
    }

    if (columnHasZero) {
        nullifyColumn(matrix, 0)
    }

    if (rowHasZero) {
        nullifyRow(matrix, 0)
    }

    return matrix
}

fun validateZeroMatrix() {
    assertTrue(
        arrayOf(
            intArrayOf(0, 2, 4),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 5, 9)
        ).contentDeepEquals(
            zeroMatrix(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(0, 6, 10),
                    intArrayOf(3, 5, 9)
                )
            )
        )
    )

    assertTrue(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 9, 0, 2)
        ).contentDeepEquals(
            zeroMatrix(
                arrayOf(
                    intArrayOf(1, 2, 4, 0, 10),
                    intArrayOf(0, 0, 10, 11, 65),
                    intArrayOf(3, 5, 9, 10, 2)
                )
            )
        )
    )

    assertTrue(
        arrayOf(
            intArrayOf(0,0,0,0),
            intArrayOf(0,4,5,0),
            intArrayOf(0,3,1,0)
        ).contentDeepEquals(
            zeroMatrix(
                arrayOf(
                    intArrayOf(0,1,2,0),
                    intArrayOf(3,4,5,2),
                    intArrayOf(1,3,1,5)
                )
            )
        )
    )
}