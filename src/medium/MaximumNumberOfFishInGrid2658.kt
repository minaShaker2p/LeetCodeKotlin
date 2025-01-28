package medium

import kotlin.reflect.jvm.internal.impl.utils.DFS.Visited

object MaximumNumberOfFishInGrid2658 {
    fun findMaxFish(grid: Array<IntArray>): Int {
        var maxResult = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
                if (grid[i][j] != 0) {
                    val currentCell = dfs(i, j, grid, visited)
                    maxResult = Math.max(maxResult, currentCell)
                }
            }
        }
        return maxResult
    }

    fun dfs(row: Int, col: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        if (row >= 0 && row < grid.size && col >= 0 && col < grid[0].size && grid[row][col] != 0 && visited[row][col].not()) {
            visited[row][col] = true
            val up = dfs(row + 1, col, grid, visited)
            val down = dfs(row - 1, col, grid, visited)
            val left = dfs(row, col - 1, grid, visited)
            val right = dfs(row, col + 1, grid, visited)
            return grid[row][col] + up + down + left + right
        } else {
            return 0
        }
    }
}