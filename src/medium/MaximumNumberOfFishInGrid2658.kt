package medium

import kotlin.reflect.jvm.internal.impl.utils.DFS.Visited

object MaximumNumberOfFishInGrid2658 {
    fun findMaxFish(grid: Array<IntArray>): Int {
        //Create adj list
        val adj = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        var maxResult = 0

        for (i in grid.indices) {
            for (j in grid[0].indices)
            {
                val visited = Array(grid.size){BooleanArray(grid[0].size){false} }
                if(grid[i][j]!=0)
                {
                    val currentCell = dfs(i,j,grid,visited,grid[i][j])
                    maxResult = Math.max(maxResult,currentCell)
                }
            }
        }

        return maxResult
    }

    fun dfs(row: Int, col: Int, grid: Array<IntArray>, visited: Array<BooleanArray>, numFish: Int): Int {
        if (row >= 0 && row < grid.size && col >= 0 && col < grid[0].size && grid[row][col] != 0 && visited[row][col].not()) {
            visited[row][col] = true
            val up = dfs(row + 1, col, grid, visited, numFish + grid[row][col])
            val down = dfs(row - 1, col, grid, visited, numFish + grid[row][col])
            val left = dfs(row, col - 1, grid, visited, numFish + grid[row][col])
            val right = dfs(row, col + 1, grid, visited, numFish + grid[row][col])
            return grid[row][col] + up + down + left + right
        } else {
            return 0
        }
    }
}