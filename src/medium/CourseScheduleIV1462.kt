package medium

import javax.print.attribute.standard.Destination

object CourseScheduleIV1462 {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adjList = HashMap<Int, MutableList<Int>>()
        for (edge in prerequisites) {
            val current = adjList.getOrDefault(edge[0], mutableListOf<Int>())
            current.add(edge[1])
            adjList[edge[0]] = current
        }

        val result = mutableListOf<Boolean>()
        for (query in queries) {
            // Reset the visited array each query
            val visited = BooleanArray(numCourses)
            result.add(
                isPrerequisite(
                    adjList,
                    visited,
                    query[0],
                    query[1]
                )
            )
        }
        return result
    }

    private fun isPrerequisite(
        adjList: HashMap<Int, MutableList<Int>>,
        visited: BooleanArray,
        src: Int,
        target: Int
    ): Boolean {
        visited[src] = true

        if (src == target)
            return true

        var answer = false
        val neighbors = adjList.getOrDefault(src, mutableListOf<Int>())

        for (adj in neighbors) {
            if (visited[adj].not()) {
                answer = answer || isPrerequisite(adjList, visited, adj, target)
            }
        }
        return answer
    }
}