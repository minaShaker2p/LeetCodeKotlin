package easy

/**
 * Given the root of a binary tree, return the sum of all left leaves.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000
 */
class sumOfLeftLeaves{
    var sum = 0
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if(root == null) return 0
        sumOfLeftLeavesHelper(root)

        return sum
    }

    private fun sumOfLeftLeavesHelper(root: TreeNode?,isLeft:Boolean=false) {
      if(root==null) return

        if(isLeft && root.left == null && root.right == null)
        {
            sum+=root.`val`
        }else
        {
            sumOfLeftLeavesHelper(root.left,true)
            sumOfLeftLeavesHelper(root.right)
        }

    }
}
