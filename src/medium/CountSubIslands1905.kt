package medium

import java.util.*


fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val totalRows = grid2.size
    val totalCols = grid2[0].size

    val visited = Array(totalRows) { BooleanArray(totalCols) { false } }
    var subIslandsCount = 0

    // Iterate on each cell in `grid1`

    for (x in 0 until totalRows) {
        for (y in 0 until totalCols) {
            // If cell at the position (x,y) in the `grid2` is not visible,
            // is a land cell in `grid2', and the island
            // starting from this cell is a sub-island in `grid1`, then we
            // increment the count od sub-island
            if (!visited[x][y] &&
                grid2.isCellLand(x, y) &&
                isSubIsland(x, y, grid1, grid2, visited)
            ) {
                subIslandsCount+=1
            }
        }
    }
    return subIslandsCount
}

private fun Array<IntArray>.isCellLand(x: Int, y: Int) = this[x][y] == 1


private fun isSubIsland(
    x: Int,
    y: Int,
    grid1: Array<IntArray>,
    grid2: Array<IntArray>,
    visited: Array<BooleanArray>
): Boolean {
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(0, -1)
    )

    var isSubIsland = true
    val totalRows = grid2.size
    val totalCols = grid2[0].size
    val pendingCells: Queue<IntArray> = LinkedList()
    // Push the starting cell in the queue and mark it as visited
    pendingCells.offer(intArrayOf(x, y))
    visited[x][y] = true

    while (pendingCells.isNotEmpty()) {

        val curr: IntArray = pendingCells.poll()
        val currX: Int = curr[0]
        val currY: Int = curr[1]

        // If the current position cell is not island cell in grid1,
        // then the current island can't be sub-island
        if (!grid1.isCellLand(currX, currY)) {
            isSubIsland = false
        }


        for (dir in directions) {
            val nextX: Int = currX + dir[0]
            val nextY: Int = currY + dir[1]

            // If the next cell is inside 'grid2', is never visitrd and
            // is a lanf cell, then we traverse to the next cell.
            if (
                nextX >= 0 &&
                nextY >= 0 &&
                nextX < totalRows &&
                nextY < totalCols &&
                !visited[nextX][nextY] &&
                grid2.isCellLand(nextX, nextY)
            ) {
                // Push the next cell in the queue and mark it is as  visited.
                pendingCells.offer(intArrayOf(nextX, nextY))
                visited[nextX][nextY] = true
            }
        }
    }
    return isSubIsland
}
