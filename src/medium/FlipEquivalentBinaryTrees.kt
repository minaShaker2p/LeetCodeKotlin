package medium

import java.util.Stack

object FlipEquivalentBinaryTrees {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        // Initialize stack to store pairs of nodes
        val nodePairStack = Stack<Array<TreeNode?>>()
        nodePairStack.push(arrayOf(root1, root2))

        // While the stack is not empty
        while (nodePairStack.isNotEmpty()) {
            val current = nodePairStack.pop()
            val node1 = current[0]
            val node2 = current[1]

            if (node1 == null && node2 == null) continue
            if (node1 == null || node2 == null) return false
            if (node1.`val` != node2.`val`) return false

            // Check both configurations: no swap and swap

            if (checkNodeValues(node1.left, node2.left) && checkNodeValues(node1.right, node2.right)) {
                nodePairStack.push(arrayOf(node1.left, node2.left))
                nodePairStack.push(arrayOf(node1.right, node2.right))
            } else if (checkNodeValues(node1.left, node2.right) && checkNodeValues(node1.right, node2.left)) {
                nodePairStack.push(arrayOf(node1.left, node2.right))
                nodePairStack.push(arrayOf(node1.right, node2.left))
            } else {
                return false
            }
        }
        return true
    }

    // Checks whether the given pair of node should be examined
    // be pushed into the stack
    private fun checkNodeValues(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) return true
        if (node1 != null && node2 != null && node1.`val` == node2.`val`)
            return true
        return false
    }
}