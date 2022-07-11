package medium

import java.util.*

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
fun rightSideView(root: TreeNode?): List<Int> {
    if(root==null) return emptyList()
 val visableList= mutableListOf<Int>()
    val queue :Queue<TreeNode> =LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty())
    {
        val size= queue.size
        for(i in 0 until size)
        {
            val current= queue.poll()
            if(i==size-1)
                visableList.add(current.`val`)
            if(current?.left!=null)
                queue.add(current.left)

            if(current?.right!=null)
                queue.add(current.right)

        }
    }
    return visableList
}