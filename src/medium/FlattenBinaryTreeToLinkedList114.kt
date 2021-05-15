package medium

import java.util.*

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
fun flatten(root: TreeNode?): Unit {
    if(root==null)
        return
    val stack = Stack<TreeNode>()

    stack.push(root)

    while (stack.isNotEmpty())
    {
        val current= stack.pop()
        if(current.right!=null)
            stack.push(current!!.right)

        if(current.left!=null)
            stack.push(current!!.left)
        if(stack.isNotEmpty())
            current.right=stack.peek()
        current.left=null
    }

}