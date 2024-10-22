package medium

import java.util.Collections
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

object KthLargestSumInBinaryTree2583 {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        val levelSumList = mutableListOf<Long>()

        while (queue.isNotEmpty()) {
            val size = queue.size
            var sumOfLevel = 0L
            for (i in 0 until size) {
                val curr = queue.remove()
                sumOfLevel += curr?.`val` ?: 0
                if (curr.left != null)
                    queue.add(curr.left)

                if (curr.right != null)
                    queue.add(curr.right)
            }
            levelSumList.add(sumOfLevel)
        }
        levelSumList.sortDescending()

        return if (k < levelSumList.size) levelSumList[k] else -1

    }
  /**
   * Approach 1: Level Order Traversal + Max Heap
   *
   */
    fun kthLargestLevelSumSolution2(root: TreeNode?, k: Int): Long {
        // Max heap
        val pq: PriorityQueue<Long> = PriorityQueue(Collections.reverseOrder())

        val bfsQueue: Queue<TreeNode> = LinkedList()
        bfsQueue.add(root)

        while (bfsQueue.isNotEmpty()) {
            // Level order traversal
            val size = bfsQueue.size
            var sumOfLevel = 0L
            for (i in 0 until size) {
                val curr = bfsQueue.remove()
                sumOfLevel += curr?.`val` ?: 0
                // Add left child
                if (curr.left != null)
                    bfsQueue.add(curr.left)

                // Add right child
                if (curr.right != null)
                    bfsQueue.add(curr.right)
            }
            pq.add(sumOfLevel)
        }

        if (pq.size < k) return -1
        for (i in 0 until k - 1) {
            pq.remove()
        }

        return pq.peek()
    }
}