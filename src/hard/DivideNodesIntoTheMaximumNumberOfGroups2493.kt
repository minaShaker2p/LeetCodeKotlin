package hard

import java.util.LinkedList
import java.util.Queue

object DivideNodesIntoTheMaximumNumberOfGroups2493 {

    // Main function to calculate the maximum number of magnificent sets
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {

        val adjList = mutableListOf<MutableList<Int>>()

        for (i in 0 until n) {
            adjList.add(mutableListOf<Int>())
        }

        for (edge in edges) {
            // Transition to 0-Index
            adjList[edge[0] - 1].add(edge[1] - 1)
            adjList[edge[1] - 1].add(edge[0] - 1)
        }

        val colors = IntArray(n) { -1 }

        for (node in 0 until n) {
            if (colors[node] != -1) continue
            //Start coloring from uncolored nodes
            colors[node] = 0
            // If the graph is not bipartite, return -1
            if (!isBipartite(adjList, node, colors)) return -1
        }
        // Calculate the longest shortest path for each node
        val distances = IntArray(n)
        for (node in 0 until n) {
            distances[node] = getLongestShortestPath(adjList, node, n)
        }

        // Calculate the total maximum numbers of groups across all the total
        var maxNumberOfGroup = 0
        val visited = BooleanArray(n)
        for (node in 0 until n) {
            if (visited[node]) continue
            // Add the number of groups for this component to the total
            maxNumberOfGroup += getNumberOfGroupsForComponent(
                adjList,
                node,
                distances,
                visited
            )
        }
        return maxNumberOfGroup
    }

    // Checks if the graph is bipartite starting from the given node
    private fun isBipartite(
        adjList: MutableList<MutableList<Int>>,
        node: Int,
        colors: IntArray
    ): Boolean {
        for (neighbor in adjList[node]) {
            // If  a neighbor has thr same color as the current node, the graph is not bipartite
            if (colors[neighbor] == colors[node]) return false

            // If the neighbor is already colored, Skip it
            if (colors[neighbor] != -1) continue

            // Assign the opposite color to the neighbor
            colors[neighbor] = (colors[node] + 1) % 2

            // Recursively check bipartiteness for the neighbor; return false if it fails
            if (!isBipartite(adjList, neighbor, colors)) return false
        }

        // If all neighbors are properly colored,return true
        return true
    }

    // Computes the longest shortest path (height) in the graph starting from the source node
    private fun getLongestShortestPath(
        adjList: MutableList<MutableList<Int>>,
        srcNode: Int,
        n: Int
    ): Int {
        // Initialize a queue for BFS and visited array
        val nodesQueue: Queue<Int> = LinkedList<Int>()
        val visited = BooleanArray(n) { false }

        nodesQueue.add(srcNode)
        visited[srcNode] = true
        var distance = 0

        // Perform BFS layer by layer
        while (nodesQueue.isNotEmpty()) {
            // Process all nodes in the current layer
            val numOfNodesInLayer = nodesQueue.size

            for (i in 0 until numOfNodesInLayer) {
                val currentNode = nodesQueue.remove()

                // Visit all unvisited neighbors of the current node
                for (neighbor in adjList[currentNode]) {
                    if (visited[neighbor]) continue
                    visited[neighbor] = true
                    nodesQueue.add(neighbor)
                }
            }
            // Increment the distance for each layer
            distance++
        }
        return distance
    }

    // Calculate the maximum number of groups for connected component
    private fun getNumberOfGroupsForComponent(
        adjList: MutableList<MutableList<Int>>,
        node: Int,
        distances: IntArray,
        visited: BooleanArray
    ): Int {
        // Start with the distance of the current node as the maximum
        var maxNumberOfGroup = distances[node]
        visited[node] = true

        // Recursively calculate the maximum for all unvisited neighbors
        for (neighbor in adjList[node]) {
            if (visited[neighbor]) continue
            maxNumberOfGroup = Math.max(
                maxNumberOfGroup, getNumberOfGroupsForComponent(
                    adjList,
                    neighbor,
                    distances,
                    visited
                )
            )
        }
        return maxNumberOfGroup
    }
}