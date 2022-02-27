package medium

import java.util.*
import kotlin.collections.HashMap

/**
 * Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).


Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 */
fun widthOfBinaryTree(root: TreeNode?): Int {
    if(root==null || (root.left==null && root.right==null))
        return 1
    val map = HashMap<TreeNode,Int>()
    val queue:Queue<TreeNode> = LinkedList<TreeNode>()
    var maxWidth=0
    queue.offer(root)
    map[root]=0

    while (queue.isNotEmpty())
    {
        var size = queue.size
        var left= map[queue.peek()]?:0
        while (size-->0)
        {
            val head = queue.poll()
            maxWidth=Math.max(maxWidth,map[head]!!-left+1)
            if(head.left!=null)
            {
                queue.offer(head.left)
                map[head.left!!]=map[head]!! * 2
            }
            if(head.right!=null)
            {
                queue.offer(head.right)
                map[head.right!!]=map[head]!! * 2 +1
            }
        }
    }
return maxWidth
}