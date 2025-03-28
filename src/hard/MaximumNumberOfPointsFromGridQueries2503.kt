package hard

import java.util.PriorityQueue

// Sorting queries and min heap expansion
object MaximumNumberOfPointsFromGridQueries2503 {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val rowCount = grid.size
        val colCount = grid[0].size
        val result = IntArray(queries.size)

        // Directions for movement (right,down,left,up)
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        // Store queries along with their original indices to restore the order later
        val queriesWithIndices = Array(queries.size) { IntArray(2) }

        for (i in queries.indices) {
            queriesWithIndices[i][0] = queries[i]
            queriesWithIndices[i][1] = i
        }

        // Sort queries by value in ascending order
       val sortedQueries =  queriesWithIndices.sortedBy { it[0] }

        // Min-heap (priority queue) to process cells in increasing order of value
        val minHeap = PriorityQueue<IntArray>(Comparator<IntArray> { arr1, arr2 -> arr1[0] - arr2[0] })

        val visited = Array(rowCount) { BooleanArray(colCount) }

        // Keep track of the number of cells processed
        var totalPoints = 0

        // Start from the top-left cell
        minHeap.add(intArrayOf(grid[0][0], 0, 0))
        visited[0][0] = true

        // Process queries in sorted order
        for (query in sortedQueries) {
            val queryValue = query[0]
            val queryIndex = query[1]

            // Expand the cells that are smaller than the current query value
            while (minHeap.isNotEmpty() && minHeap.peek()[0] < queryValue) {
                val top = minHeap.poll()
                val cellValue = top[0]
                val currentRow = top[1]
                val currentCol = top[2]

                // Increment count of valid cells
                totalPoints++

                // Explore all four possible directions
                for (dir in directions) {
                    val newRow = currentRow + dir[0]
                    val newCol = currentCol + dir[1]

                    // Check if the new cell is within bounds and not visited
                    if (newRow >= 0 &&
                        newCol >= 0 &&
                        newRow < rowCount &&
                        newCol < colCount &&
                        !visited[newRow][newCol]
                    ) {
                        minHeap.add(intArrayOf(grid[newRow][newCol], newRow, newCol))
                        // Mark as visited
                        visited[newRow][newCol] = true
                    }
                }
            }
            //Store the result for this query
            result[queryIndex] = totalPoints
        }

        return result
    }
}