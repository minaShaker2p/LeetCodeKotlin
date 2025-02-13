package medium

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

object MinimumOperationsToExceedThresholdValueII3066 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val minHeap: PriorityQueue<Int> = PriorityQueue<Int>()

        nums.forEach { num ->
            minHeap.add(num)
        }

        var numOfOperations = 0

        while (minHeap.size >= 2) {
            val peek = minHeap.remove()
            if (peek >= k)
                break

            val secondSmallestValue = minHeap.remove()

            val current = (peek *2)+secondSmallestValue
            minHeap.add(current)
            numOfOperations++
        }

        return numOfOperations

    }
}