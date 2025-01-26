package hard

import java.util.HashMap
import java.util.LinkedList
import java.util.Queue

object MaximumEmployeesToBeInvitedToMeeting2127 {
    // Calculate the maximum distance from a given start node
    private fun bfs(startNode: Int, visitedNodes: MutableSet<Int>, reveredGraph: List<MutableList<Int>>): Int {

        // Queue to store the nodes and their distances
        val queue: Queue<Array<Int>> = LinkedList()
        queue.add(arrayOf(startNode, 0))
        var maxDistance = 0
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentNode = current[0]
            val currentDistance = current[1]
            for (neighbor in reveredGraph[currentNode]) {
                // Skip already visited node
                if (visitedNodes.contains(currentNode))
                    continue

                visitedNodes.add(neighbor)
                queue.add(arrayOf(neighbor, currentDistance + 1))
                maxDistance = Math.max(maxDistance, currentDistance + 1)
            }
        }
        return maxDistance
    }

    fun maximumInvitations(favorite: IntArray): Int {
        val numPeople = favorite.size
        val reveredGraph: MutableList<MutableList<Int>> = mutableListOf()
        // Build a revered graph when each node point to its admirers
        for (i in favorite.indices) {
            reveredGraph.add(mutableListOf())
        }

        for (person in 0 until numPeople) {
            reveredGraph[favorite[person]].add(person)
        }

        var longestCycle = 0
        var twoCycleInvitation = 0
        val visited = BooleanArray(numPeople)

        // Find all cycles in the graph
        for (person in 0 until numPeople) {
            if (visited[person].not()) {
                // Track visited person and their distances
                val visitedPersons = HashMap<Int, Int>()
                var currentPerson = person
                var distance = 0
                while (true) {
                    if (visited[currentPerson]) break
                    visited[currentPerson] = true
                    visitedPersons[currentPerson] = distance++
                    var nextPerson = favorite[currentPerson]

                    // Cycle detected
                    if (visitedPersons.containsKey(nextPerson)) {
                        var cycleLength = distance - visitedPersons.getOrDefault(nextPerson, 0)
                         longestCycle = longestCycle.coerceAtLeast(cycleLength)

                        // Handle cycle of length 2
                        if (cycleLength == 2) {
                            val visitedNodes = mutableSetOf<Int>()
                            visitedNodes.add(currentPerson)
                            visitedNodes.add(nextPerson)
                            twoCycleInvitation += 2 +
                                    bfs(currentPerson, visitedNodes, reveredGraph) +
                                    bfs(nextPerson, visitedNodes, reveredGraph)
                        }
                        break
                    }
                    currentPerson = nextPerson
                }
            }

        }
        return Math.max(longestCycle,twoCycleInvitation)
    }
}