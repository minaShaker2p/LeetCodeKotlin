package medium

import java.util.LinkedList
import java.util.Queue

object MaximumNumberOfMovesInGrid2684 {
    fun maxMoves(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue: Queue<IntArray> = LinkedList<IntArray>()

        for (row in grid.indices) {
            queue.add(intArrayOf(row, 0))
        }

        var level = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val curr = queue.remove()
                val currentRow = curr[0]
                val currentCol = curr[1]

                // check row,col+1
                if (currentCol < n - 1 && grid[currentRow][currentCol + 1] > grid[currentRow][currentCol]) {
                    queue.add(intArrayOf(currentRow, currentCol + 1))
                }

                // check row-1,col+1
                if (currentRow > 0 && currentCol < n - 1 && grid[currentRow - 1][currentCol + 1] > grid[currentRow][currentCol]) {
                    queue.add(intArrayOf(currentRow - 1, currentCol + 1))
                }

                // check row,col+1
                if (currentRow < m - 1 && currentCol < n - 1 && grid[currentRow + 1][currentCol + 1] > grid[currentRow][currentCol]) {
                    queue.add(intArrayOf(currentRow + 1, currentCol + 1))
                }
            }

            if (queue.isNotEmpty())
                level++
        }

        return level

    }
}