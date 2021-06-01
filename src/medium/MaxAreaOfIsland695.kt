package medium

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 */

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var max = 0

    for( i in grid.indices)
    {
        for(j in grid[i].indices)
        {
            max = Math.max(max,dfs(grid,i,j))
        }
    }
return max
}

fun dfs(grid: Array<IntArray>,i :Int , j :Int):Int
{
    if(i < 0 ||  i>= grid.size || j < 0 || j>= grid[i].size || grid[i][j]==0)
        return 0
    grid[i][j] = 0
    var count  = 1
    count+= dfs(grid,i+1,j)
    count+= dfs(grid,i-1,j)
    count+= dfs(grid,i,j+1)
    count+= dfs(grid,i,j-1)
    return count
}