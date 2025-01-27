package easy

object FindIfPathExistsInGraph1971 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {

        // Build adjacency map for the graph
        val adjMap = HashMap<Int, MutableList<Int>>()
        for (i in 0 until n) {
            adjMap[i] = mutableListOf<Int>()
        }

        for (edge in edges) {
            val startVertex = adjMap.getOrDefault(edge[0], mutableListOf())
            startVertex.add(edge[1])
            adjMap[edge[0]] = startVertex

            val endVertex = adjMap.getOrDefault(edge[1], mutableListOf())
            endVertex.add(edge[0])
            adjMap[edge[1]] = endVertex
        }

        // traverse the graph using dfs to check if there is a path between source and destination
        val visited = BooleanArray(n)
        visited[source] = true

        val result = dfs(adjMap, visited, source, destination)
        println(result)
        return result

    }

    private fun dfs(
        adjMap: HashMap<Int, MutableList<Int>>,
        visited: BooleanArray,
        source: Int,
        destination: Int
    ): Boolean {

        if (source == destination)
            return true

        for (neighbor in adjMap.getOrDefault(source, mutableListOf())) {
            if (visited[neighbor].not()) {
                visited[neighbor] = true
                if (dfs(adjMap, visited, neighbor, destination))
                    return true
            }
        }
        return false
    }
}