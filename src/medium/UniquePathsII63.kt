package medium

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 */

class Solution {
   lateinit var  dp: Array<IntArray>
    fun uniquePathsWithObstacles(grid: Array<IntArray>): Int {
          dp = Array(grid.size) { IntArray(grid[0].size){-1} }

        return dfs(grid,0,0)
    }
    fun dfs(grid: Array<IntArray>,i :Int,j:Int) :Int
    {
        if(i <0 || j<0 || i == grid.size || j == grid[0].size || grid[i][j]==1)
            return 0

        if(i==grid.size-1&& j == grid[0].size-1)
            return 1

        if(dp[i][j] >-1)
            return dp[i][j]

        dp[i][j]= dfs(grid,i+1,j) + dfs(grid,i,j+1)
        return dp[i][j]

    }
}