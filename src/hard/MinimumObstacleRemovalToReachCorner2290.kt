package hard


object MinimumObstacleRemovalToReachCorner2290 {
    // Directions for movement: right,left,down,up
    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size // Rows
        val n = grid[0].size // Cols

        // Distance matrix to store the minimum obstacles removed to reach each cell
        val minObstacles = Array(m) { IntArray(n) { Int.MAX_VALUE } }

        minObstacles[0][0] = 0

        val deque = ArrayDeque<IntArray>()
        deque.add(intArrayOf(0, 0, 0)) // { obstacle,row,col }

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()
            val obstacles = current[0]
            val row = current[1]
            val col = current[2]

            // Explore all four possible directions from the current cell
            for (dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]
                if (isValid(grid, newRow, newCol) && minObstacles[newRow][newCol] == Int.MAX_VALUE) {
                    if (grid[newRow][newCol] == 1) {
                        // If it's an obstacle, add 1 to obstacles and push to the back
                        minObstacles[newRow][newCol] = obstacles + 1
                        deque.addLast(intArrayOf(obstacles + 1, newRow, newCol))
                    } else {
                        // If it's an empty cell, keep the obstacle count and push to the front
                        minObstacles[newRow][newCol] = obstacles
                        deque.addFirst(intArrayOf(obstacles, newRow, newCol))
                    }
                }
            }

        }

        return minObstacles[m - 1][n - 1]
    }

    // Helper method to check if the cell is within the grid bounds
    private fun isValid(grid: Array<IntArray>, row: Int, col: Int): Boolean {
        return (row >= 0 && col >= 0 && row < grid.size && col < grid[0].size)
    }
}