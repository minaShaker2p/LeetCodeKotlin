package medium

fun removeStones(stones: Array<IntArray>): Int {
    val n = stones.size

    // Adjacency list to store graph connections
    val adjacencyList = Array<MutableList<Int>>(n) { mutableListOf<Int>() }

    // Build the graph: Connect stones that share row and column
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                adjacencyList[i].add(j)
                adjacencyList[j].add(i)
            }
        }
    }

    var numOfConnectedComponents = 0
    val visited = BooleanArray(n)

    // Traverse all stones using DFS to count connected components
    for (i in 0 until n) {
        if (!visited[i]) {
            depthFirstSearch(adjacencyList, visited, i)
            numOfConnectedComponents++
        }
    }

    // Maximum stones that can be removed is total stones minus number of connected components
    return n - numOfConnectedComponents
}

// DFS to visit all stones in a connected components
private fun depthFirstSearch(
    adjacencyList: Array<MutableList<Int>>,
    visited: BooleanArray,
    stone: Int
) {
    visited[stone] = true
    for (neighbor in adjacencyList[stone]) {
        if (!visited[neighbor]) {
            depthFirstSearch(adjacencyList, visited, neighbor)
        }
    }
}