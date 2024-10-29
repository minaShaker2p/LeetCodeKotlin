package medium

import java.util.LinkedList
import java.util.Queue

object MaximumNumberOfMovesInGrid2684 {
    fun maxMoves(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(m) { BooleanArray(n) { false } }
        val dirs = intArrayOf(-1, 0, 1)

        for (row in grid.indices) {
            queue.add(intArrayOf(row, 0, 0))
            visited[row][0] = true
        }

        var maxMove = Int.MIN_VALUE

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val current = queue.remove()
                val currentRow = current[0]
                val currentCol = current[1]
                val count = current[2]

                maxMove = maxMove.coerceAtLeast(count)

                for (dir in dirs) {
                    val nextRow = currentRow + dir
                    val nextCol = currentCol + 1

                    if (nextRow >= 0 && nextCol >= 0 && nextCol < n && nextRow < m &&
                        visited[nextRow][nextCol].not() &&
                        grid[nextRow][nextCol] > grid[currentRow][currentCol]
                    ) {
                        visited[nextRow][nextCol] = true
                        queue.add(intArrayOf(nextRow, nextCol, count + 1))
                    }
                }
            }
        }
        return maxMove
    }
}