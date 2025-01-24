package medium

import java.util.LinkedList
import java.util.Queue

object FindEventualSafeStates802 {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val indegree = IntArray(n)
        val adj = mutableListOf<MutableList<Int>>()

        for (i in 0 until n) {
            adj.add(mutableListOf<Int>())
        }

        for (i in 0 until n) {
            for (node in graph[i]) {
                adj[node].add(i)
                indegree[i]++
            }
        }

        val queue: Queue<Int> = LinkedList<Int>()

        // push all the nodes with indegree zero in the queue
        for (i in 0 until n) {
            if (indegree[i] == 0) {
                queue.add(i)
            }
        }

        val safe = BooleanArray(n)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            safe[node] = true

            for (neighbor in adj[node]) {
                // delete the edge "node -> neighbor|
                indegree[neighbor]--
                if (indegree[neighbor] == 0)
                    queue.add(neighbor)
            }
        }

        val safeNodes = mutableListOf<Int>()
        for (i in 0 until n) {
            if (safe[i]) {
                safeNodes.add(i)
            }
        }

        return safeNodes
    }
}