package easy

import java.util.*

/**
Given the root of a binary tree, invert the tree, and return its root.



Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 */

fun invertTree(root: TreeNode?): TreeNode? {

    val queue : Queue<TreeNode?> = LinkedList()

    if(root == null) return null

    queue.add(root)

    while (queue.isNotEmpty())
    {
        var size = queue.size

        while (size-- > 0)
        {
            val current = queue.remove()
            // swap left and right nodes
            val temp = current?.left
            current?.left = current?.right
            current?.right = temp
            if(current?.left !=null)
                queue.add(current.left)
            if(current?.right !=null)
                queue.add(current.right)
        }
    }

    return root
}