package medium

import java.util.LinkedList
import java.util.Queue

object ReverseOddLevelsOfBinaryTree2415 {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var level = 0

        while (queue.isNotEmpty()) {
            val currentLevelNodes = mutableListOf<TreeNode>()
            currentLevelNodes.clear()
            for (i in 0 until queue.size) {
                val currentNode = queue.remove()
                currentLevelNodes.add(currentNode)

                if (currentNode.left != null)
                    queue.add(currentNode.left)

                if (currentNode.right != null)
                    queue.add(currentNode.right)
            }
            // If the level is odd
            if ((level % 2) == 1) {
                var left = 0
                var right = currentLevelNodes.size-1
                while (left < right) {
                    val rightNodeValue = currentLevelNodes[right].`val`
                    val leftNodeValue = currentLevelNodes[left].`val`
                    currentLevelNodes[left].`val` = rightNodeValue
                    currentLevelNodes[right].`val` = leftNodeValue
                    left++
                    right--
                }
            }
            level++

        }
        return root
    }
}