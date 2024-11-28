package hard

object MinimumObstacleRemovalToReachCorner2290 {
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val graph = HashMap<IntArray, MutableList<IntArray>>()
        val adjs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        // build graph
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                graph[intArrayOf(i, j)] = mutableListOf()
                for (adj in adjs) {
                    val nextRow = i + adj[0]
                    val nextCol = j + adj[1]
                    if (nextRow in 1..<m && nextCol > 0 && nextCol < n) {
                        val current = graph.getOrDefault(intArrayOf(i, j), mutableListOf())
                        current.add(intArrayOf(nextRow, nextCol, grid[nextRow][nextCol]))
                        graph[intArrayOf(i, j)] = current
                    }
                }
            }
        }

        return 0
    }
}