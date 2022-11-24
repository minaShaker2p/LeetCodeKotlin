package easy

import java.util.*

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    var level = 0
    var minLevel = 0

    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(root)
    minLevel = 1
    while (queue.isNotEmpty()) {
        level++

        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current?.left == null && current?.right == null)
                return level

            if (current.left != null)
                queue.add(current.left!!)
            if (current.right != null)
                queue.add(current.right!!)
        }
    }
    return level
}