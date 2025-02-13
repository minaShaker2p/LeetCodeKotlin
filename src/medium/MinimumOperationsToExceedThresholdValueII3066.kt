package medium

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

object MinimumOperationsToExceedThresholdValueII3066 {
    fun minOperations(nums: IntArray, k: Int): Int {
        val minHeap: PriorityQueue<Long> = PriorityQueue<Long>()

        nums.forEach { num ->
            minHeap.add(num.toLong())
        }

        var numOfOperations = 0

        while (minHeap.peek() < k) {
            val x = minHeap.remove()
            val y =  minHeap.remove()

            val current: Long = ((x * 2) + y)
            minHeap.add(current)
            numOfOperations++
        }

        return numOfOperations
    }
}