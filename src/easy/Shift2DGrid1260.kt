package easy

/*
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.


Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
 */

fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    var r = 0
    var array = grid
    var newGrid=grid
    while (r < k) {
        array = Array(grid.size) { IntArray(grid[0].size) }
        newGrid.forEachIndexed { i, row ->
            row.forEachIndexed { j, _ ->
                if (i == (grid.size - 1) && j == (row.size - 1)) {
                    array[0][0] = newGrid[i][j]
                }else if (j == (row.size - 1) && i< (grid.size - 1)) {
                    array[i + 1][0] = newGrid[i][j]
                }else {
                    array[i][j+1] = newGrid[i][j]
                }
            }
        }
        r++
        newGrid=array
    }
    return array.map {
        it.toList()
    }

}