package medium

import java.util.*

object MovePiecesToObtainString2337 {
    fun canChange(start: String, target: String): Boolean {
        // Queue to store characters and indices from both strings
        val startQueue: Queue<Pair<Char, Int>> = LinkedList()
        val targetQueue: Queue<Pair<Char, Int>> = LinkedList()

        // Record non-underscore characters and their indices
        for (i in start.indices) {
            if (start[i] != '_')
                startQueue.add(Pair(start[i], i))
        }

        for (i in target.indices) {
            if (target[i] != '_')
                targetQueue.add(Pair(target[i], i))
        }

        // If the number of pieces don't match, return false
        if (startQueue.size != targetQueue.size) return false

        // Compare each piece's type and position
        while (startQueue.isNotEmpty()) {
            val startPair = startQueue.remove()
            val targetPair = targetQueue.remove()
            val startChar: Char = startPair.first
            val startIndex: Int = startPair.second
            val targetChar: Char = targetPair.first
            val targetIndex: Int = targetPair.second

            // Check character match and movement rules
            if (startChar != targetChar ||
                (startChar == 'L' && startIndex < targetIndex) ||
                (startChar == 'R' && startIndex > targetIndex)
            ) {
                return false
            }
        }

        return true
    }
}