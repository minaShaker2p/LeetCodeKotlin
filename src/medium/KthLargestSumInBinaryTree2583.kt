package medium

import java.util.LinkedList
import java.util.Queue

object KthLargestSumInBinaryTree2583 {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        val levelSumList = mutableListOf<Long>()
        levelSumList.add(root?.`val`?.toLong()?:0)

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
}