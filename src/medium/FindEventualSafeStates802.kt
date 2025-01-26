package medium

import java.util.*
import kotlin.collections.HashMap

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

    fun eventualSafeNodesSolution2(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val visit = BooleanArray(n)
        val inStack = BooleanArray(n)


        for (i in 0 until n) {
            dfs(node = i, adj = graph, visit = visit, inStack = inStack)
        }

        val safeNodesResult = mutableListOf<Int>()
        for (i in 0 until n) {
            if (inStack[i].not())
                safeNodesResult.add(i)
        }
        return safeNodesResult
    }
}

fun dfs(node: Int, adj: Array<IntArray>, visit: BooleanArray, inStack: BooleanArray): Boolean {
    // If the node is already in the stack, then we have a cycle
    if (inStack[node])
        return true

    if (visit[node])
        return false

    // Mark this current node as visited and part of the current stack of recursion
    visit[node] = true
    inStack[node] = true

    for (neighbor in adj[node]) {
        if (dfs(neighbor, adj, visit, inStack))
            return true
    }

    // Remove the node from the stack
    inStack[node] = false
    return false
}