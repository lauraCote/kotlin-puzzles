import kotlin.test.assertTrue

fun cellIsAlive(x: Int, y: Int, board: Array<IntArray>): Boolean {
    return board[x][y] == 1 || board[x][y] == -1
}

fun gameOfLife(board: Array<IntArray>): Unit {
    for (x in board.indices) {
        for (y in board[x].indices) {
            var cell = board[x][y]
            var liveNeighbors = 0
            if (x > 0 && cellIsAlive(x-1, y, board)) {
                liveNeighbors++
            }
            if (x > 0 && y > 0 && cellIsAlive(x - 1, y - 1, board)) {
                liveNeighbors++
            }
            if (y > 0 && cellIsAlive(x, y - 1, board)) {
                liveNeighbors++
            }
            if (x < board.size - 1 && cellIsAlive(x + 1, y, board)) {
                liveNeighbors++
            }

            if (x < board.size - 1 && y < board[x].size - 1 && cellIsAlive(x + 1, y + 1, board)) {
                liveNeighbors++
            }

            if (y < board[x].size - 1 && cellIsAlive(x, y + 1, board)) {
                liveNeighbors++
            }

            if (x > 0 && y < board[x].size - 1 && cellIsAlive(x-1, y + 1, board)) {
                liveNeighbors++
            }

            if (x < board.size - 1 && y > 0 && cellIsAlive(x + 1, y - 1, board)) {
                liveNeighbors++
            }

            if (cell == 1 && liveNeighbors < 2) {
                board[x][y] = -1
            }
            if (cell == 1 && liveNeighbors > 3) {
                board[x][y] = -1
            }
            if (cell == 0 && liveNeighbors == 3) {
                board[x][y] = 2
            }
        }
    }

    for (x in board.indices) {
        for (y in board[x].indices) {
            if (board[x][y] > 0) {
                board[x][y] = 1
            } else {
                board[x][y] = 0
            }
        }
    }
}

fun validateGameOfLife() {
    var game = arrayOf(
        intArrayOf(0,1,0),
        intArrayOf(0,0,1),
        intArrayOf(1,1,1),
        intArrayOf(0,0,0)
    )
    var response = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(1,0,1),
        intArrayOf(0,1,1),
        intArrayOf(0,1,0)
    )
    gameOfLife(game)
    assertTrue(game.contentDeepEquals(response))
}