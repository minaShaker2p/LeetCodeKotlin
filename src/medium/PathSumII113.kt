package medium

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
class SolutionPathSum {
    val result = mutableListOf<List<Int>>()
    val paths = IntArray(1000)
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        getTreePathsRecursively(root, targetSum, 0)
        return result
    }

    private fun getTreePathsRecursively(root: TreeNode?, targetSum: Int, length: Int) {
        if (root == null) return

        var len = length
        paths[len++] = root.`val`

        if (root.left == null && root.right == null)
            getValidPath(len, targetSum)
        else
            getTreePathsRecursively(root.left, targetSum, len)
        getTreePathsRecursively(root.right, targetSum, len)

    }

    private fun getValidPath(len: Int, targetSum: Int) {
        var sum = 0
        val list = mutableListOf<Int>()
        for (i in 0 until len) {
            sum += paths[i]
            list.add(paths[i])
        }
        if (sum == targetSum)
            result.add(list)

    }
}