package medium

import java.util.*

object MovePiecesToObtainString2337 {
    fun canChange(start: String, target: String): Boolean {
        val startQueue: Queue<Char> = LinkedList()
        val targetQueue: Queue<Char> = LinkedList()

        for (char in start) {
            if (char != '_')
                startQueue.add(char)
        }

        for (char in target) {
            if (char != '_')
                targetQueue.add(char)
        }

        if(startQueue.size != targetQueue.size) return false

        while (startQueue.isNotEmpty() && targetQueue.isNotEmpty())
        {
            val currStart = startQueue.remove()
            val currentTarget = targetQueue.remove()
            if(currentTarget!=currStart)
                return false
        }

        return true
    }
}