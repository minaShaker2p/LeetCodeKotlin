package easy

import java.util.*

/**
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    var max = 0
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        var size = queue.size
        max++
        while (size-- > 0) {
            val current = queue.remove()
            if(current?.left !=null)
                queue.add(current.left)
            if(current?.right !=null)
                queue.add(current.right)

        }

    }
    return max
}