package medium

import kotlin.reflect.jvm.internal.impl.utils.DFS.Visited

object RedundantConnection684 {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size

        val adjList = mutableListOf<MutableList<Int>>()

        for (i in 0 until n) {
            adjList.add(mutableListOf<Int>())
        }

        for (edge in edges) {
            val visited = BooleanArray(n)

            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return intArrayOf(edge[0], edge[1])
            }
            adjList[edge[0] - 1].add(edge[1] - 1)
            adjList[edge[1] - 1].add(edge[0] - 1)
        }

        return intArrayOf()

    }

    // Perform DFS and returns true if there's path between src and target
    private fun isConnected(
        src: Int,
        target: Int,
        visited: BooleanArray,
        adjList: MutableList<MutableList<Int>>
    ): Boolean {

        visited[src] = true
        if (src == target)
            return true

        var isFound = false
        for (neighbor in adjList[src]) {
            if (visited[neighbor].not()) {
                isFound = isFound || isConnected(neighbor, target, visited, adjList)
            }
        }
        return isFound
    }
}