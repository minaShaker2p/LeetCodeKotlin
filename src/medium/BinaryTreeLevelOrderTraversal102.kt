package medium

import java.util.*

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */



// Iterative solution Time complexity O(N) // Space Complexity O(N)
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    if(root == null)
        return result
    val queue :Queue<TreeNode> =LinkedList<TreeNode>()
    queue.offer(root)
    while (queue.isNotEmpty())
    {
        var size = queue.size
        val level  = mutableListOf<Int>()
        while (size -- >0)
        {
            val current = queue.remove()
            level.add(current.`val`)
            if(current.left!=null)
                queue.add(current.left)

            if(current.right!=null)
                queue.add(current.right)
        }
        result.add(level)
    }
 return  result
}