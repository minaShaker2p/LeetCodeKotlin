package hard

import java.util.HashSet

/**
 * Given a binary tree, we install cameras on the nodes of the tree.

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:

Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Note:

The number of nodes in the given tree will be in the range [1, 1000].
Every node has value 0.
 */

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }
var cam =0
val covered = HashSet<TreeNode?>()
fun minCameraCover(root: TreeNode?): Int {
    if(root==null)
        return 0
 covered.add(null) // add leaves
    dfs(root,null)

return  cam
}

fun dfs(node: TreeNode?,parent:TreeNode?)
{
    if(node!=null)
    {
        dfs(node.left,node)
        dfs(node.right,node)

        if(parent ==null&& ! covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right))
        {
            covered.add(node)
            covered.add(parent)
            covered.add(node.left)
            covered.add(node.right)
            cam++
        }
    }
}