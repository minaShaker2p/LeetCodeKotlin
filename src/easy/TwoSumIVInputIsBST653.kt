package easy

import java.util.*
import kotlin.collections.HashSet

/**
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.



Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true


Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 */

fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = HashSet<Int>()
    val queue :Queue<TreeNode> = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty())
    {
        var size = queue.size
        while (size-- >0)
        {
            val current = queue.remove()
            val currentValue = current.`val`
            val remaining = k - currentValue
            if(set.contains(currentValue))
                return true
            else
                set.add(remaining)

            current?.left?.let { queue.add(it) }
            current?.right?.let { queue.add(it) }
        }
    }
return false
}